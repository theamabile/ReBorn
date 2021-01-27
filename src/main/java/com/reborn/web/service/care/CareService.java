package com.reborn.web.service.care;

import java.util.List;

import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareReview;
import com.reborn.web.entity.care.CareReviewView;
import com.reborn.web.entity.care.CareView;
import com.reborn.web.entity.care.CareWish;

public interface CareService {

//	List<CareView> getViewList();
	Care getCareByCareRegNo(String careRegNo);
	CareView getCareViewByCareRegNo(String careRegNo);
	
	List<Care> getList(int page, int size, String field, String query);
	List<CareView> getViewList(int page, int size, String field, String query);
	int getCount(String field, String query);
	
	int insert(Care care);
	int insertCareList(List<Care> careList);
	int update(Care care);
	
	void getWishedList(List<CareView> careList);	
	int insertWish(CareWish cw);
	int deleteWish(CareWish cw);	
	
	CareReview getReview(int id);
	List<CareReview> getReviewList(int page, int size, String careRegNo);
	List<CareReviewView> getReviewViewList(int page, int size, String careRegNo);
	int insertReview(CareReview cr);
	int updateReview(CareReview cr);
	int deleteReview(int id);
	
}