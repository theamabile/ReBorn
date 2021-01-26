package com.reborn.web.dao.mybatis.animal;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.animal.AnimalUpKindDao;
import com.reborn.web.entity.animal.AnimalUpKind;

@Repository
public class MyBatisAnimalUpKindDao implements AnimalUpKindDao{
	private SqlSession session;
	private AnimalUpKindDao mapper;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
		this.mapper = session.getMapper(AnimalUpKindDao.class);
	}

	@Override
	public int insert(AnimalUpKind upkind) {
		// TODO Auto-generated method stub
		return mapper.insert(upkind);
	}

	@Override
	public int update(AnimalUpKind upkind) {
		// TODO Auto-generated method stub
		return mapper.update(upkind);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public AnimalUpKind get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<AnimalUpKind> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public AnimalUpKind getUpKindByCode(String code) {
		// TODO Auto-generated method stub
		return mapper.getUpKindByCode(code);
	}
}
