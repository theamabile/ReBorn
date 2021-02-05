package com.reborn.web.controller.member;

import java.sql.Date;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reborn.web.entity.member.Member;
import com.reborn.web.service.member.CertificationService;
import com.reborn.web.service.member.MemberService;

@Controller
@RequestMapping("/member/info/")
public class MemberInfoController {

	@Autowired
	MemberService service;
	

	// 회원가입
	@GetMapping("join")
	public String join() {
		return "home.member.join";
	}

	@PostMapping("join")
	public String join(Member m, @RequestParam(value = "year", defaultValue = "2000") String year,
			@RequestParam(value = "month", defaultValue = "1") String month,
			@RequestParam(value = "day", defaultValue = "1") String day, String emailId, String emailAddress,
			String customAddress) {

		// birthDay 형 변환
		String date = year + "-" + month + "-" + day;
		Date d = Date.valueOf(date);
		System.out.println(emailAddress);

//		email 
		String email;
		if (!emailAddress.equals("none"))
			email = emailId + "@" + emailAddress;
		else
			email = emailId + "@" + customAddress;

		m.setEmail(email);
		m.setBirthDay(d);
		m.setAuthorityId(2); // 회원으로 등록

		service.insert(m);
		return "redirect:../login";
	}


	/*
	 * 
	 * // 정보 수정
	 * 
	 * @PostMapping("/edit") public String edit(Member m) {
	 * 
	 * System.out.println(m);
	 * 
	 * Member newMb= new Member(); newMb.setLoginId(m.getLoginId());
	 * newMb.setName(m.getName()); newMb.setGender(m.getGender());
	 * newMb.setPw(m.getPw()); newMb.setNickname(m.getNickname());
	 * newMb.setPhone(m.getPhone()); newMb.setAuthorityId(2);
	 * 
	 * newMb.setEmail(null); newMb.setBirthDay(null);
	 * 
	 * // service.insert(newMb);
	 * 
	 * return "redirect:../login"; }
	 */

}