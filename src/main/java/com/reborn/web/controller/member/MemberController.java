package com.reborn.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class MemberController {

	
	@GetMapping("login")
	public String login( ) {

	
		
		return "member.login";
	}
	@PostMapping("login")
	public String login(String loginId, String pw ) {

		System.out.println(loginId+pw);
		return "member.login";
	}
	
	@RequestMapping("find-id")
	public String findId() {
		return "member.find-id";
	}
	@RequestMapping("find-id-result")
	public String findIdResult() {
		return "member.find-id-result";
	}
	@RequestMapping("find-pw")
	public String findPw() {
		return "member.find-pw";
	}
	@RequestMapping("find-pw-result")
	public String findPwResult() {
		return "member.find-pw-result";
	}
	
}
