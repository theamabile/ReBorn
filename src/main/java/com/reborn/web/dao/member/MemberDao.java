package com.reborn.web.dao.member;

import com.reborn.web.entity.member.Member;

public interface MemberDao {
	
	 Member get(String loginId);

	int insert(Member member);

	int checkId(String loginId);
	int checkEmail(String Email);
	
	int  checkMemberPhone(String loginId, String name, String phone);
	
	Member getMember(String email, String name);

	int update(Member m);

	int checkMemberEmail(String loginId, String name, String email);

}
