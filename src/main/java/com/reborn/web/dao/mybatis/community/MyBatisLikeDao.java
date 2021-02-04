package com.reborn.web.dao.mybatis.community;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.community.LikeDao;
import com.reborn.web.entity.community.Like;
@Repository
public class MyBatisLikeDao implements LikeDao {

	private SqlSession session;
	
	private LikeDao mapper;
	@Autowired
	public MyBatisLikeDao(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(LikeDao.class);
	}
	
	@Override
	public int getLikeCount(int id) {
		// TODO Auto-generated method stub
		return mapper.getLikeCount(id);
	}
	
	@Override
	public int getCount(int id, int memberId) {
		// TODO Auto-generated method stub
		return mapper.getCount(id, memberId);
	}
	
	@Override
	public void delete(int id, int memberId) {
		
		mapper.delete(id, memberId);
		
	}
	
	@Override
	public void insert(Like like) {
		mapper.insert(like);
		
	}
	
}
