package com.reborn.web.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reborn.web.entity.member.Member;
import com.reborn.web.service.member.MemberService;

@Controller
@RequestMapping("/member/info/")   
public class MemberInfoController {
	
	@Autowired
	MemberService service;
	
	/*
	 * @GetMapping("/join/sendSMS")
	 * 
	 * @ResponseBody public String sendSMS(String phoneNumber) {
	 * 
	 * Random rand = new Random(); String numStr = ""; for(int i=0; i<6; i++) {
	 * String ran = Integer.toString(rand.nextInt(10)); numStr+=ran; }
	 * 
	 * System.out.println("수신자 번호 : " + phoneNumber); System.out.println("인증번호 : " +
	 * numStr); certificationService.certifiedPhoneNumber(phoneNumber,numStr);
	 * return numStr; }
	 */
	
	
	//회원가입
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