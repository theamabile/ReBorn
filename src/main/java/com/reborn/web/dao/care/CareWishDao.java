package com.reborn.web.dao.care;

import java.util.List;

import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareView;
import com.reborn.web.entity.care.CareWish;

public interface CareWishDao {

	Care get(int memberId, String careRegNo);
	
	List<CareWish> getCareListByMemberId(int memberId, List<CareView> list);
	
	Care insert(int memberId, CareWish cw);
//	Care update(int memberId, Care care);
	Care delete(int memberId, String careRegNo);
	
}
