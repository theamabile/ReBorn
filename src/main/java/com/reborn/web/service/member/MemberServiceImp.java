package com.reborn.web.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.member.MemberDao;
import com.reborn.web.entity.member.Member;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	public MemberServiceImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(Member member) {
		// TODO Auto-generated method stub
		return memberDao.insert(member);
	}

	@Override
	public String getpw(String loginId) {

		Member m= memberDao.get(loginId);
		String pw = m.getPw();
		
		return pw;
	}

}
