package com.reborn.web.dao.mybatis.area;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.area.SigunguCategoryDao;
import com.reborn.web.entity.area.AreaView;
import com.reborn.web.entity.area.SigunguCategory;

@Repository
public class MyBatisSigunguCategoryDao implements SigunguCategoryDao {

	private SigunguCategoryDao mapper;
	
	@Autowired
	public MyBatisSigunguCategoryDao(SqlSession session) {
		mapper = session.getMapper(SigunguCategoryDao.class);
	}
	
	@Override
	public List<SigunguCategory> getList() {

		return mapper.getList();
	}
	

	public List<AreaView> getAreaViewList(){
		
		return mapper.getAreaViewList();
	}

	@Override
	public int insertSigungu(SigunguCategory sigungu) {
		return mapper.insertSigungu(sigungu);
	}

	@Override
	public int deleteSigungu(int orgCd) {
		return mapper.deleteSigungu(orgCd);
	}

}
