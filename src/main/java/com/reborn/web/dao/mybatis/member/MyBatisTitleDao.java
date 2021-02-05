package com.reborn.web.dao.mybatis.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.member.MemberDao;
import com.reborn.web.dao.member.TitleDao;
import com.reborn.web.entity.member.Title;

@Repository
public class MyBatisTitleDao implements TitleDao {

	private SqlSession session;
	private TitleDao mapper;

	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
		this.mapper = session.getMapper(TitleDao.class);
	}

	@Override
	public String get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);

	}	


	
}
