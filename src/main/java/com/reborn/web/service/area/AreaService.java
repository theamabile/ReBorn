package com.reborn.web.service.area;

import java.util.List;

import com.reborn.web.entity.area.AreaView;
import com.reborn.web.entity.area.SidoCategory;
import com.reborn.web.entity.area.SigunguCategory;

public interface AreaService {
	
	List<SidoCategory> getSidoList();
	List<SigunguCategory> getSigunguList();
	List<AreaView> getAreaViewList();

	int insertSido(SidoCategory sido);
	int insertSigungu(SigunguCategory sigungu);
	
	int deleteSido(int uprCd);
	int deleteSigungu(int orgCd);
	
}
