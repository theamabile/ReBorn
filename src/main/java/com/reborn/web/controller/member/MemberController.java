package com.reborn.web.controller.member;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reborn.web.service.member.CertificationService;
import com.reborn.web.service.member.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	MemberService service;
	
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
	public String findIdResult(@RequestParam(value = "loginId") String loginId) {
		System.out.println(loginId);
		return "member.find-id-result";
	}
	
	@RequestMapping("find-pw")
	public String findPw() {
		return "member.find-pw";
	}
	
	@RequestMapping("find-pw-result")
	public String findPwResult(@RequestParam(value = "loginId") String loginId) {
		return "member.find-pw-result";
	}
	
	//휴대전화 인증 
	@Autowired
	CertificationService certificationService;
	
	 @PostMapping("/sendSMS")
	 @ResponseBody
	 public String sendSMS(@RequestParam(value = "phone") String phone,
			 											@RequestParam(value = "page") String page) {
	 
	  return certificationService.certifiedPhoneNumber(phone,page);
	  }
	 
		// 아이디 중복 검사
		@PostMapping("/check-id")
		public void checkId(@RequestParam("id") String id, HttpServletResponse response) throws Exception {
			service.checkId(id, response);
		}

		// 이메일 중복 검사
		@PostMapping("/check-email")
		public void checkEmail(@RequestParam("email") String email, HttpServletResponse response) throws Exception {
			 service.checkEmail(email, response);
		}	
		
		// 회원 정보 조회
		@PostMapping("/check-member")
		public void checkMember(@RequestParam("email") String email, @RequestParam("name") String name, HttpServletResponse response) throws Exception {

			service.checkMember(email,name, response);
		}	
		
		// 패스워드 회원 확인
		@PostMapping("/check-member/phone")
		public void checkMember(@RequestParam("loginId") String loginId, @RequestParam("name") String name, @RequestParam("phone") String phone, HttpServletResponse response) throws Exception {

			service.checkMember(loginId,name,phone, response);
		}	
}