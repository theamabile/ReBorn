package com.reborn.web.dao.mybatis.name;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.name.NameDao;
import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.Name;
import com.reborn.web.entity.name.NameView;
import com.reborn.web.entity.name.VoteView;

@Repository
public class MyBatisNameDao implements NameDao{

	private SqlSession session;
	private NameDao mapper;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
		this.mapper = session.getMapper(NameDao.class);
	}
	
	@Override
	public int insert(Name name){
		// TODO Auto-generated method stub
		return mapper.insert(name);
	}

	@Override
	public int update(Name name) {
		// TODO Auto-generated method stub
		return mapper.update(name);
	}

	@Override
	public int delete(long animalId, String name) {
		// TODO Auto-generated method stub
		return mapper.delete(animalId, name);
	}	

	@Override
	public Name get(long animalId, String name) {
		// TODO Auto-generated method stub
		return mapper.get(animalId, name);
	}

	@Override
	public List<Name> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public List<Name> getList(int offset, int size, String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getList(offset, size, field, query);
	}

	@Override
	public NameView getView(long animalId, String name) {
		// TODO Auto-generated method stub
		return mapper.getView(animalId, name);
	}

	@Override
	public List<NameView> getViewList(int offset, int size, String orderField, String orderQuery, String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getViewList(offset, size, orderField, orderQuery, field, query);
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getCount(field, query);
	}

	@Override
	public NameView getBestName(long animalId) {
		// TODO Auto-generated method stub
		return mapper.getBestName(animalId);
	}

	@Override
	public List<Long> getAddedIdsByMemberId(int memberId, List<VoteView> list) {
		// TODO Auto-generated method stub
		return mapper.getAddedIdsByMemberId(memberId, list);
	}
	
}
