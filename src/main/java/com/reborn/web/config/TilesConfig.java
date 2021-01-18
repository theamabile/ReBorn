package com.reborn.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.SimpleSpringPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration      /* 설정 자동 인식 */
public class TilesConfig {
	// @bean : 스프링이 관리하는 객체를 관리하는 방이 있음 tiles를 반환
	// 이 큰 방을 ioc container라고 부름. 여기에 @Bean이 붙은 아이들이 반환하는 애들을 다 큰 방에 담아둠.
	// 스프링 부팅 될 때 @Bean이라고 표기된걸 다 호출해서 방에 담음.
	// ioc 컨테이너에 담기면 스프링이 사라지지 않게 관리해줌
   @Bean               
   public TilesConfigurer tilesConfigurer() {
      TilesConfigurer tilesConfigurer = new TilesConfigurer();
      tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"}); // tiles를 어디다가 두었니
      tilesConfigurer.setCheckRefresh(true);
      //ViewPreparer에서 Autowired가 가능하게 하는 설정
      tilesConfigurer.setPreparerFactoryClass(SimpleSpringPreparerFactory.class);
      return tilesConfigurer;
   }
   
   
   // TilesViewResolver : 실질적으로 tiles 일을함
   // 얘가 TilesConfigurer를 읽어서 사용함
   @Bean
   public TilesViewResolver tilesViewResolver() {
      TilesViewResolver viewResolver = new TilesViewResolver();  // 뷰를 찾아준다
      viewResolver.setViewClass(TilesView.class);
      viewResolver.setOrder(1);
      
      return viewResolver;
   }
   
}
