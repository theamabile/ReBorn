package com.reborn.web.service.care;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.care.CareDao;
import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareView;

@Service
public class CareServiceImp implements CareService {
	
	@Autowired
	private CareDao careDao;

	@Override
	public Care getCareByCareRegNo(String careRegNo) {
		Care c = null;
		
		c = careDao.getCareByCareRegNo(careRegNo);	
		
		return c;
	}

	@Override
	public CareView getCareViewByCareRegNo(String careRegNo) {
		CareView cv = null;
	
		cv = careDao.getCareViewByCareRegNo(careRegNo);	
		
		return cv;
	}

	@Override
	public List<Care> getList(int page, int size, String field, String query) {

		List<Care> list = null;
		
		int offset = (page-1)*size;//10,20,30,40,50,60...
		
		list = careDao.getList(offset, size, field, query);	
		
		return list;
	}
	
	@Override
	public List<CareView> getViewList(int page, int size, String field, String query) {
		List<CareView> list = null;

		int offset = (page-1)*size;//10,20,30,40,50,60...
		
		list = careDao.getViewList(offset, size, field, query);	
		
		return list;
	}

	@Override
	public int insert(Care care) {
		int result = 0;
		
		result = careDao.insert(care);	
		
		return result;
	}

	@Override
	public int insertCareList(List<Care> careList) {		
		int result = 0;
		
		for(Care care : careList)
			result += careDao.insert(care);	
		
		return result;
	}

	@Override
	public int update(Care care) {
		int result = 0;
		
		result = careDao.update(care);	
		
		return result;
	}

	@Override
	public int getCount(String field, String query) {
		int result = 0;
		
		result = careDao.getCount(field, query);	

		return result;
	}

}
