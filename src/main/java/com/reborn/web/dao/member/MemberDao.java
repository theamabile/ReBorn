package com.reborn.web.dao.member;

import com.reborn.web.entity.member.Member;

public interface MemberDao {
	
	 Member get(String loginId);

	int insert(Member member);

}
