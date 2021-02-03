package com.reborn.web.controller.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reborn.web.entity.member.Member;
import com.reborn.web.service.member.MemberService;

@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	
	@Autowired
	MemberService service;
	
	/*
	 * @Autowired HttpSession session = request.getSession();
	 */
	
	@GetMapping("info")
	public String info(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		
		String loginId = (String)session.getAttribute("loginId");
		
		Member m = service.get(loginId);
		System.out.println(m);
		model.addAttribute("m", m);
		
		return "home.mypage.info";
	}
	@GetMapping("imgInput")
	public String imgInput(Model model,@RequestParam(value = "loginId") String loginId) {
		
		
		Member m = service.get(loginId);
		
		model.addAttribute("m", m);
		
		return "home.mypage.imgInput";
	}
}
