package com.reborn.web.dao.care;

import java.util.List;

import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareView;

public interface CareDao {

	Care getCareByCareRegNo(String careRegNo);
	CareView getCareViewByCareRegNo(String careRegNo);
	
	List<Care> getList(int offset, int size, String field, String query);
	List<CareView> getViewList(int offset, int size, String field, String query);
	
	int insert(Care care);
	int update(Care care);

}
