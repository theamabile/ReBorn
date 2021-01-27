package com.reborn.web.dao.mybatis.animal;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.animal.AnimalKindDao;
import com.reborn.web.entity.animal.AnimalKind;

@Repository
public class MyBatisAnimalKindDao implements AnimalKindDao{
	
	private SqlSession session;
	private AnimalKindDao mapper;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(AnimalKindDao.class);
	}

	@Override
	public int insert(AnimalKind kind) {
		// TODO Auto-generated method stub
		return mapper.insert(kind);
	}

	@Override
	public int update(AnimalKind kind) {
		// TODO Auto-generated method stub
		return mapper.update(kind);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public AnimalKind get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<AnimalKind> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public AnimalKind getKindByCode(String code) {
		// TODO Auto-generated method stub
		return mapper.getKindByCode(code);
	}

	@Override
	public List<AnimalKind> getKindListByUpKindCode(String upKindCode) {
		// TODO Auto-generated method stub
		return mapper.getKindListByUpKindCode(upKindCode);
	}
	
}
