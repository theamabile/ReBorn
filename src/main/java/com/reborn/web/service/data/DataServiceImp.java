package com.reborn.web.service.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.data.DataDao;
import com.reborn.web.entity.data.InfoView;

@Service
public class DataServiceImp implements DataService {
	
	@Autowired
	private DataDao dataDao;
	
	
	@Override
	public InfoView getView(int id) {
		return dataDao.getView(id);
	}	
	
	@Override
	public List<InfoView> getViewList(int page, int size, int categoryId) {
		int offset = (page-1) * size;
		return dataDao.getViewList(offset, size, categoryId);
	}

	@Override
	public int getCount(int categoryId) {
		
		return dataDao.getCount(categoryId);
	}

	@Override
	public int updateHit(int id) {
		return dataDao.updateHit(id);
		
	}

	
	
}
