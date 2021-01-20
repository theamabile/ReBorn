package com.reborn.web.dao.area;

import java.util.List;

import com.reborn.web.entity.area.AreaView;
import com.reborn.web.entity.area.SigunguCategory;

public interface SigunguCategoryDao {

	List<SigunguCategory> getList();

	List<AreaView> getAreaViewList();
	
}
