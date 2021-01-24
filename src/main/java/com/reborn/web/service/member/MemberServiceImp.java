package com.reborn.web.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.member.MemberDao;
import com.reborn.web.entity.member.Member;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	//패스워드 암호화 
	 private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public MemberServiceImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(Member member) {
		//패스워드 암호화 
		String encodePassword = passwordEncoder.encode(member.getPw());
		member.setPw(encodePassword); 
		
		
		return memberDao.insert(member);
	}

	@Override
	public String getpw(String loginId) {

		Member m= memberDao.get(loginId);
		String pw = m.getPw();
		
		return pw;
	}

}
