package com.reborn.web.dao.mybatis.care;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.care.CareReviewDao;
import com.reborn.web.entity.care.CareReview;
import com.reborn.web.entity.care.CareReviewView;

@Repository
public class MyBatisCareReviewDao implements CareReviewDao{

	private CareReviewDao mapper;
	
	@Autowired
	public MyBatisCareReviewDao(SqlSession session) {
		mapper = session.getMapper(CareReviewDao.class);
	}

	@Override
	public CareReview get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<CareReview> getList(int offset, int size, String careRegNo) {
		return mapper.getList(offset, size, careRegNo);
	}

	@Override
	public List<CareReviewView> getViewList(int offset, int size, String careRegNo) {
		return mapper.getViewList(offset, size, careRegNo);
	}

	@Override
	public int insert(CareReview cr) {
		return mapper.insert(cr);
	}

	@Override
	public int update(CareReview cr) {
		return mapper.update(cr);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public int getReviewCount(String careRegNo) {
		return mapper.getReviewCount(careRegNo);
	}

	@Override
	public double getReviewAvg(String careRegNo) {
		return mapper.getReviewAvg(careRegNo);
	}
	
}
