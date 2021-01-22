package com.reborn.web.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reborn.web.entity.member.Member;
import com.reborn.web.service.member.MemberService;

@Controller
@RequestMapping("/member/info/")   
public class MemberInfoController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("login")
	public String login(String loginId, String pw ) {
		
//		String password = service.getpw(loginId);
		
//		if(password)
		
		
		return "home.member.login";
	}
	
	@GetMapping("join")
	public String join() {
		return "home.member.join";
	}
	@PostMapping("join")
	public String join(Member m) {
		
		System.out.println(m);
		
		Member newMb= new Member();
		newMb.setLoginId(m.getLoginId());
		newMb.setName(m.getName());
		newMb.setGender(m.getGender());
		newMb.setPw(m.getPw());
		newMb.setNickname(m.getNickname());
		newMb.setPhone(m.getPhone());
		newMb.setAuthorityId(2);
		
		newMb.setEmail(null);
		newMb.setBirthDay(null);
		
		service.insert(newMb);
		
	    return "redirect:../login";
	}
}