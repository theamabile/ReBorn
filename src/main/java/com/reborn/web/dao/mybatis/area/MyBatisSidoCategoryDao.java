package com.reborn.web.dao.mybatis.area;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.area.SidoCategoryDao;
import com.reborn.web.entity.area.SidoCategory;

@Repository
public class MyBatisSidoCategoryDao implements SidoCategoryDao {

	private SidoCategoryDao mapper;
	
	@Autowired
	public MyBatisSidoCategoryDao(SqlSession session) {
		mapper = session.getMapper(SidoCategoryDao.class);
	}
	
	@Override
	public List<SidoCategory> getList() {
		
		return mapper.getList();
	}

	@Override
	public int insertSido(SidoCategory sido) {

		return mapper.insertSido(sido);
	}

	@Override
	public int deleteSido(int uprCd) {

		return mapper.deleteSido(uprCd);
	}

}
