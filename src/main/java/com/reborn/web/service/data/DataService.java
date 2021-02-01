package com.reborn.web.service.data;

import java.util.List;

import com.reborn.web.entity.data.InfoView;

public interface DataService {

	InfoView getView(int id);
	List<InfoView> getViewList(int page, int size, int categoryId);

	int getCount(int categoryId);
	int updateHit(int id);

	

}
