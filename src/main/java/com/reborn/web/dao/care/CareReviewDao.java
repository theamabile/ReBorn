package com.reborn.web.dao.care;

import java.util.List;

import com.reborn.web.entity.care.CareReview;
import com.reborn.web.entity.care.CareReviewView;

public interface CareReviewDao {

	CareReview get(int id);

	List<CareReview> getList(int offset, int size, String careRegNo);
	List<CareReviewView> getViewList(int offset, int size, String careRegNo);
	
	int insert(CareReview cr);
	int update(CareReview cr);
	int delete(int id);
	
}
