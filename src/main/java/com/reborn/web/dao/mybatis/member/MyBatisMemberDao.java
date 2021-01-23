package com.reborn.web.dao.mybatis.member;

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



}
