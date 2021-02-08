package com.reborn.web.service.care;

import java.util.List;

import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareReview;
import com.reborn.web.entity.care.CareReviewView;
import com.reborn.web.entity.care.CareView;
import com.reborn.web.entity.care.CareWish;

public interface CareService {

//	List<CareView> getViewList();
	// 보호소 =============================================================================
	Care getCareByCareRegNo(String careRegNo);
	CareView getCareViewByCareRegNo(String careRegNo);
	
	List<Care> getList(int page, int size, String field, String query);
	List<CareView> getViewList(int page, int size, String field, String query);
	int getCount(String field, String query);
	
	int insert(Care care);
	int insertCareList(List<Care> careList);
	int update(Care care);
	
	// 찜 ================================================================================
	// List에 찜한 목록들을 채워 넣어준다. 반환x, 로그인 해야가능
	void getWishedList(int memberId, List<CareView> list);
	int insertWish(CareWish cw);
	int deleteWish(CareWish cw);	
	
	// 리뷰 ===============================================================================	
	CareReview getReview(int id);
	List<CareReview> getReviewList(int page, int size, String careRegNo);
	List<CareReviewView> getReviewViewList(int page, int size, String careRegNo);
	int getReviewCount(String careRegNo);
	int insertReview(CareReview cr);
	int updateReview(CareReview cr);
	int deleteReview(int id);
	double getReviewAvg(String careRegNo);
	
}