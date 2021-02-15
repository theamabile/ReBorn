package com.reborn.web.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.reborn.web.entity.member.Member;
import com.reborn.web.service.member.MemberService;

@Component
public class MemberScheduler {

	@Autowired
	MemberService memberService;

	// 아침 9시~10시 사이에 업데이트
//	@Scheduled(cron = "0 * 9 * * ?")
	@Scheduled(cron = "0/10 * * * * *") //10초마다
	public void memberTitleUpdate() {
		//System.out.println("회원 타이틀 업데이트");
		List<Member> list = memberService.getList();
		
		for(Member m : list) {
			//System.out.println(m);
			if(m.getNameCount() <= 20 || m.getPoint() <= 300 )            // 20회 300포인트 이하 초보작명가 
				m.setTitleId(1);
			else if((20 < m.getNameCount() &&m.getNameCount() <= 40)    // 40회 600포인트 이하 이름자판기 
							|| 300 <  m.getPoint() &&m.getPoint() <= 600)
				m.setTitleId(2);
			else                   //언어의 마술사
				m.setTitleId(3);
			memberService.update(m);				// 업데이트
		}
				
	}
	
	
}
