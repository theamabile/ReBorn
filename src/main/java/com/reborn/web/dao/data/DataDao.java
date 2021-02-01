package com.reborn.web.dao.data;

import java.util.List;

import com.reborn.web.entity.data.InfoView;

public interface DataDao {
	
	
	InfoView getView(int id);
	
	List<InfoView> getViewList(int offset, int size, int categoryId);
	
	int getCount(int categoryId);

	int updateHit(int id);

	

}
