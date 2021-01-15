package com.reborn.web.dao.mybatis.shelter;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.shelter.ShelterDao;

@Repository
public class MyBatisShelterDao implements ShelterDao {

	private ShelterDao mapper;
	
	@Autowired
	public MyBatisShelterDao(SqlSession session) {
		mapper = session.getMapper(ShelterDao.class);
	}
	
	
	@Override
	public int test() {
		
		return mapper.test();
	}

}
