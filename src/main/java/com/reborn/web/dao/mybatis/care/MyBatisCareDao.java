package com.reborn.web.dao.mybatis.care;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.care.CareDao;
import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareView;

@Repository
public class MyBatisCareDao implements CareDao {

	private CareDao mapper;
	
	@Autowired
	public MyBatisCareDao(SqlSession session) {
		mapper = session.getMapper(CareDao.class);
	}
	
	@Override
	public Care getCareByCareRegNo(String careRegNo) {
		Care c = null;
	
		c = mapper.getCareByCareRegNo(careRegNo);	
		
		return c;
	}
	
	@Override
	public CareView getCareViewByCareRegNo(String careRegNo) {
		CareView cv = null;
	
		cv = mapper.getCareViewByCareRegNo(careRegNo);	
		
		return cv;
	}

	@Override
	public List<Care> getList(int offset, int size, String field, String query) {
		List<Care> list = null;
		
		list = mapper.getList(offset, size, field, query);	
		
		return list;
	}

	@Override
	public List<CareView> getViewList(int offset, int size, String field, String query) {
		List<CareView> list = null;
		
		list = mapper.getViewList(offset, size, field, query);	
		
		return list;
	}

	@Override
	public int insert(Care care) {
		int result = 0;
		
		result = mapper.insert(care);
		
		return result;
	}


	@Override
	public int update(Care care) {
		int result = 0;
		
		result = mapper.update(care);
		
		return result;
	}

	@Override
	public int getCount(String field, String query) {
		int result = 0;
		
		result = mapper.getCount(field, query);
		
		return result;
	}


	
//	@Override
//	public int test() {
//		
//		return mapper.test();
//	}

}
