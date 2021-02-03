package com.reborn.web.service.care;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.care.CareDao;
import com.reborn.web.dao.care.CareReviewDao;
import com.reborn.web.dao.care.CareWishDao;
import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareReview;
import com.reborn.web.entity.care.CareReviewView;
import com.reborn.web.entity.care.CareView;
import com.reborn.web.entity.care.CareWish;

@Service
public class CareServiceImp implements CareService {
	
	private CareDao careDao;
	private CareWishDao careWishDao;
	private CareReviewDao careReviewDao;
	
	@Autowired
	public CareServiceImp(CareDao careDao, CareWishDao careWishDao, CareReviewDao careReviewDao) {
		this.careDao = careDao;
		this.careWishDao = careWishDao;
		this.careReviewDao = careReviewDao;
	}	
	
	@Override
	public Care getCareByCareRegNo(String careRegNo) {
		Care c = null;
		
		c = careDao.getCareByCareRegNo(careRegNo);	
		
		return c;
	}


	@Override
	public CareView getCareViewByCareRegNo(String careRegNo) {
		CareView cv = null;
	
		cv = careDao.getCareViewByCareRegNo(careRegNo);	
		
		return cv;
	}

	@Override
	public List<Care> getList(int page, int size, String field, String query) {
		List<Care> list = null;
		
		if(page < 1)
			page = 1;
		
		int offset = (page-1)*size;//10,20,30,40,50,60...
		
		list = careDao.getList(offset, size, field, query);	
		
		return list;
	}
	
	@Override
	public List<CareView> getViewList(int page, int size, String field, String query) {
		List<CareView> list = null;

		if(page < 1)
			page = 1;
		
		int offset = (page-1)*size;//10,20,30,40,50,60...
		
		list = careDao.getViewList(offset, size, field, query);	
		
		return list;
	}

	@Override
	public int insert(Care care) {
		int result = 0;
		
		result = careDao.insert(care);	
		
		return result;
	}

	@Override
	public int insertCareList(List<Care> careList) {		
		int result = 0;
		
		for(Care care : careList)
			result += careDao.insert(care);	
		
		return result;
	}

	@Override
	public int update(Care care) {
		int result = 0;
		
		result = careDao.update(care);	
		
		return result;
	}

	@Override
	public int getCount(String field, String query) {
		int result = 0;
		
		result = careDao.getCount(field, query);	

		return result;
	}

	@Override
	public void getWishedList(List<CareView> list) {
		
		// ============================================================
		// ============================================================
		// 테스트용 아이디
		int memberId = 3;
		// ============================================================
		// ============================================================
		
		List<CareWish> wishList = careWishDao.getCareListByMemberId(memberId, list);
		
		for(CareView cv : list) {
			cv.setWish(false);
			
			for(CareWish wish : wishList) {
				String careNum = cv.getCareRegNo();
				String wishNum = wish.getCareRegNo();
				
				if( careNum.equals(wishNum) ) {
					cv.setWish(true);
					
					wishList.remove(wish);
					break;
				}
			}
		}
		
	}

	@Override
	public int insertWish(CareWish cw) {
		int result = 0;
		
		result = careWishDao.insert(cw);
		
		return result;
		
	}

	@Override
	public int deleteWish(CareWish cw) {
		int result = 0;
		
		result = careWishDao.delete(cw.getMemberId(), cw.getCareRegNo());
		
		return result;
	}

	@Override
	public CareReview getReview(int id) {
		CareReview cr = new CareReview();
		
		cr = careReviewDao.get(id);
		
		return cr;
	}

	@Override
	public List<CareReview> getReviewList(int page, int size, String careRegNo) {
		List<CareReview> list = new ArrayList<>();

		int offset = (page-1)*size;//10,20,30,40,50,60...
		
		list = careReviewDao.getList(offset, size, careRegNo);
		
		return list;
	}

	@Override
	public List<CareReviewView> getReviewViewList(int page, int size, String careRegNo) {
		List<CareReviewView> list = new ArrayList<>();

		if(page < 1)
			page = 1;
		
		int offset = (page-1)*size;//10,20,30,40,50,60...
		
		list = careReviewDao.getViewList(offset, size, careRegNo);
		
		return list;
	}

	@Override
	public int insertReview(CareReview cr) {
		int result = 0;
		
		result = careReviewDao.insert(cr);
		
		return result;
	}

	@Override
	public int updateReview(CareReview cr) {
		int result = 0;
		
		result = careReviewDao.update(cr);
		
		return result;
	}

	@Override
	public int deleteReview(int id) {
		int result = 0;
		
		result = careReviewDao.delete(id);
		
		return result;
	}

	@Override
	public int getReviewCount(String careRegNo) {
		int result = 0;
		
		result = careReviewDao.getReviewCount(careRegNo);
		
		return result;
	}

	@Override
	public double getReviewAvg(String careRegNo) {
		double result = 0;
		
		result = careReviewDao.getReviewAvg(careRegNo);
		
		return result;
	}

}
