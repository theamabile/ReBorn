package com.reborn.web.dao.mybatis.animal;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.animal.AnimalDao;
import com.reborn.web.entity.animal.Animal;


@Repository
public class MyBatisAnimalDao implements AnimalDao{
	
	private SqlSession session;
	private AnimalDao mapper;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(AnimalDao.class);
	}

	@Override
	public int insert(Animal animal) {
		// TODO Auto-generated method stub
		return mapper.insert(animal);
	}

	@Override
	public int update(Animal animal) {
		// TODO Auto-generated method stub
		return mapper.update(animal);
	}

	@Override
	public int delete(long desertionNo) {
		// TODO Auto-generated method stub
		return mapper.delete(desertionNo);
	}

	@Override
	public Animal get(long desertionNo) {
		// TODO Auto-generated method stub
		return mapper.get(desertionNo);
	}

	@Override
	public List<Animal> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public List<Animal> getList(int offset, int size, String upKindCd, String kindCd, Date startDate, Date endDate,String neuter) {
		// TODO Auto-generated method stub
		return mapper.getList(offset, size, upKindCd, kindCd, startDate, endDate, neuter);
	}

	@Override
	public int getCount(String upkind, String kind, Date startDate, Date endDate, String neuter) {
		// TODO Auto-generated method stub
		return mapper.getCount(upkind, kind, startDate, endDate, neuter);
	}	

	@Override
	public Animal getByDesertionNo(long desertionNo) {
		// TODO Auto-generated method stub
		return mapper.getByDesertionNo(desertionNo);
	}

	
}
