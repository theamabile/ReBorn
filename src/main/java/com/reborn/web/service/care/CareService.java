package com.reborn.web.service.care;

import java.util.List;

import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareView;

public interface CareService {

//	List<CareView> getViewList();
	Care getCareByCareRegNo(String careRegNo);
	CareView getCareViewByCareRegNo(String careRegNo);
	
	List<Care> getList(int offset, int size, String field, String query);
	List<CareView> getViewList(int offset, int size, String field, String query);
	
	int insert(Care care);
	int insertCareList(List<Care> careList);

	int update(Care care);
	
}