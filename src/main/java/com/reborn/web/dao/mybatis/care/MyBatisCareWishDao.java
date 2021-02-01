package com.reborn.web.dao.mybatis.care;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.care.CareWishDao;
import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareView;
import com.reborn.web.entity.care.CareWish;

@Repository
public class MyBatisCareWishDao implements CareWishDao{

	private CareWishDao mapper;
	
	@Autowired
	public MyBatisCareWishDao(SqlSession session) {
		mapper = session.getMapper(CareWishDao.class);
	}
	
	@Override
	public Care get(int memberId, String careRegNo) {
		return mapper.get(memberId, careRegNo);
	}

	@Override
	public List<CareWish> getCareListByMemberId(int memberId, List<CareView> list) {
		return mapper.getCareListByMemberId(memberId, list);
	}

	@Override
	public int insert(CareWish cw) {
		return mapper.insert(cw);
	}

//	@Override
//	public Care update(int memberId, Care care) {
//		return mapper.update(memberId, care);
//	}

	@Override
	public int delete(int memberId, String careRegNo) {
		return mapper.delete(memberId, careRegNo);
	}
	
}
