package com.reborn.web.controller.mypage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reborn.web.entity.member.Member;
import com.reborn.web.service.member.MemberService;
import com.reborn.web.service.member.TitleService;

@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	TitleService titleService;
	
	/*
	 * @Autowired HttpSession session = request.getSession();
	 */
	
	@GetMapping("info")
	public String info(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		String loginId = (String)session.getAttribute("loginId");
		
		Member m = memberService.get(loginId);
		int titleId= m.getTitleId();
		String title = titleService.get(titleId);
		
		model.addAttribute("m", m);
		model.addAttribute("title", title);
		
//		이메일
		List<String> addrList = new ArrayList<String>(); 
		addrList.add("naver.com");
		addrList.add("daum.net");
		addrList.add("gmail.com");
		
		String[] emailStrs = m.getEmail().split("@");  
		int result = addrList.indexOf(emailStrs[1]);
		System.out.println(result);
		if(result < 0 ) {
			model.addAttribute("isCustomAddr", true);
		} else {
			model.addAttribute("isCustomAddr", false);
		}			

		model.addAttribute("emailId", emailStrs[0]);
		model.addAttribute("emailAddress", emailStrs[1]);

		
	
		return "home.mypage.info";
	}
	
	//회원 수정 
	@PostMapping("info")
	public String info(Member m, HttpServletRequest req) {
		System.out.println(m);
		
		HttpSession session = req.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		Member newMb= memberService.get(loginId);
		
		newMb.setLoginId(m.getLoginId());
		newMb.setName(m.getName());
		newMb.setGender(m.getGender());
		newMb.setPw(m.getPw());
		newMb.setNickname(m.getNickname());
		newMb.setPhone(m.getPhone());
		newMb.setAuthorityId(2);
		
		newMb.setEmail(null);
		newMb.setBirthDay(null);
		
		memberService.insert(newMb);
		
		return "redirect:../../main";
	};
	
	

	@GetMapping("imgInput")
	public String imgInput(Model model,HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		Member m = memberService.get(loginId);

		
		model.addAttribute("m", m);
		
		return "home.mypage.imgInput";
	}
}
