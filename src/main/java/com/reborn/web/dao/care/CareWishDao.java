package com.reborn.web.dao.care;

import java.util.List;

import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareView;
import com.reborn.web.entity.care.CareWish;

public interface CareWishDao {

	Care get(int memberId, String careRegNo);
	
	List<CareWish> getCareListByMemberId(int memberId, List<CareView> list);
	
	int insert(CareWish cw);
//	Care update(int memberId, Care care);
	int delete(int memberId, String careRegNo);
	
}
