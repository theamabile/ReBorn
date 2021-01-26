package com.reborn.web.dao.mybatis.name;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.name.VoteDao;
import com.reborn.web.entity.name.Vote;
import com.reborn.web.entity.name.VoteView;

@Repository
public class MyBatisVoteDao implements VoteDao{

	private SqlSession session;
	private VoteDao mapper;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
		this.mapper = session.getMapper(VoteDao.class);  // session이 set되고 하기
	}

	@Override
	public int insert(Vote vote) {
		// TODO Auto-generated method stub
		return mapper.insert(vote);
	}

	@Override
	public int update(Vote vote) {
		// TODO Auto-generated method stub
		return mapper.update(vote);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public int deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		return mapper.deleteAll(ids);
	}

	@Override
	public Vote get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<Vote> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public List<Vote> getList(int offset, int size, String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getList(offset,size,field,query);
	}

	@Override
	public List<VoteView> getViewList(int offset, int size, String orderField, String orderQuery,
			String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getViewList(offset, size, orderField, orderQuery, field, query);
	}	

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getCount(field, query);
	}


}
