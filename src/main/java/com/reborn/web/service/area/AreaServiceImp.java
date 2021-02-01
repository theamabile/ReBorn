package com.reborn.web.service.area;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.area.SidoCategoryDao;
import com.reborn.web.dao.area.SigunguCategoryDao;
import com.reborn.web.entity.area.AreaView;
import com.reborn.web.entity.area.SidoCategory;
import com.reborn.web.entity.area.SigunguCategory;

@Service
public class AreaServiceImp implements AreaService {

	private SidoCategoryDao sidoCategoryDao;
	private SigunguCategoryDao sigunguCategoryDao;
	
	@Autowired
	public AreaServiceImp(SidoCategoryDao sidoCategoryDao, SigunguCategoryDao sigunguCategoryDao) {
		this.sidoCategoryDao = sidoCategoryDao;
		this.sigunguCategoryDao = sigunguCategoryDao;
	}

	@Override
	public List<SidoCategory> getSidoList() {
		return sidoCategoryDao.getList();
	}

	@Override
	public List<SigunguCategory> getSigunguList() {
		return sigunguCategoryDao.getList();
	}
	
	@Override
	public List<AreaView> getAreaViewList() {
		return sigunguCategoryDao.getAreaViewList();
	}

	@Override
	public int insertSido(SidoCategory sido) {
		return sidoCategoryDao.insertSido(sido);
	}

	@Override
	public int insertSigungu(SigunguCategory sigungu) {
		return sigunguCategoryDao.insertSigungu(sigungu);
	}

	@Override
	public int deleteSido(int uprCd) {
		return sidoCategoryDao.deleteSido(uprCd);
	}

	@Override
	public int deleteSigungu(int orgCd) {
		return sigunguCategoryDao.deleteSigungu(orgCd);
	}

}
