package com.reborn.web.service.member;

import com.reborn.web.entity.member.Member;

public interface MemberService {

	int insert(Member member);

	String getpw(String loginId);

}
