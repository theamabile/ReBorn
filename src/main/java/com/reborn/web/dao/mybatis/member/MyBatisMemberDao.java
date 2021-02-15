package com.reborn.web.dao.mybatis.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.member.MemberDao;
import com.reborn.web.entity.member.Member;

@Repository
public class MyBatisMemberDao implements MemberDao {

	private SqlSession session;
	private MemberDao mapper;

	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
		this.mapper = session.getMapper(MemberDao.class);
	}	

	@Override
	public Member get(String loginId) {
		
		return mapper.get(loginId);
	}

	@Override
	public int insert(Member member) {

   	return  mapper.insert(member);
	}

	@Override
	public int checkId(String loginId) {
		// TODO Auto-generated method stub
		return  mapper.checkId(loginId);
	}

	@Override
	public int checkEmail(String Email) {
		// TODO Auto-generated method stub
		return  mapper.checkEmail(Email);
	}

	@Override
	public Member getMember(String email, String name) {
		// TODO Auto-generated method stub
		return mapper.getMember(email,name);
		}


	@Override
	public int update(Member m) {
		// TODO Auto-generated method stub
		return mapper.update(m);
	}

	@Override
	public int checkMemberPhone(String loginId, String name, String phone) {
		// TODO Auto-generated method stub
		return mapper.checkMemberPhone(loginId,name, phone);
	}
	@Override
	public int checkMemberEmail(String loginId, String name, String email) {
		// TODO Auto-generated method stub
		return mapper.checkMemberEmail(loginId,name, email);
	}

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}
	
}
