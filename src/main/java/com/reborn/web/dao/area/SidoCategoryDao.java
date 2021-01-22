package com.reborn.web.dao.area;

import java.util.List;

import com.reborn.web.entity.area.SidoCategory;

public interface SidoCategoryDao {

	List<SidoCategory> getList();

	int insertSido(SidoCategory sido);
	int deleteSido(int uprCd);
	
}
