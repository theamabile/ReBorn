package com.reborn.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configurable
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
				.antMatchers("/member/*/*").permitAll()           //  어떤 사용자든 다 들어가야하는 곳. 
				.antMatchers("/main").authenticated()        //모두검사 

				.and()
			.formLogin()
				.loginPage("/member/login")
				.loginProcessingUrl("/member/login")
				.defaultSuccessUrl("/main")              // 그냥 로그인페이지로 들어왔을 경우
				.and()
			.logout()
				.logoutUrl("/member/logout")
				.logoutSuccessUrl("/index")
				.invalidateHttpSession(true)        //사용자가 쓰던 세션을 모두 유효하지 않도록 바꿔준다.
				.and()
			.csrf()       //cross site Request 설정
			.disable();      
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select loginId id, pw password,1 enabled from Member where loginId=?")            
		.authoritiesByUsernameQuery("select m.loginId id, aut.name roldId"
												+" from Member m"
												+ " join Authority aut on m.authorityId = aut.id  where loginId=?")
	         .passwordEncoder(new BCryptPasswordEncoder())        //권한에 대한 정보
		.passwordEncoder(new BCryptPasswordEncoder());                 //패스워드 암호화(단방향)
	
	/*	.inMemoryAuthentication()          // 데이터 베이스로 관리될 만큼 사용자가 유동적이지 않은 경우
		.withUser("dmsgml158")
				.password("{noop}zxcv1234!")
				.roles("MEMBER","ADMIN");*/
		
	}

}
