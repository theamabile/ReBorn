package com.reborn.web.dao.mybatis.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.data.DataDao;
import com.reborn.web.entity.data.InfoView;

@Repository
public class MyBatisDataDao implements DataDao {
	private DataDao mapper;
	
	@Autowired
	public MyBatisDataDao(SqlSession session) {
		mapper = session.getMapper(DataDao.class);
	}
	
	@Override
	public InfoView getView(int id) {
		return mapper.getView(id);
	}

	@Override
	public List<InfoView> getViewList(int offset, int size, int categoryId) {
		return mapper.getViewList(offset, size, categoryId);
	}

	@Override
	public int getCount(int categoryId) {
		
		return  mapper.getCount(categoryId);
	}

	
	
	
	
}
