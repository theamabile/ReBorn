package com.reborn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")       // 루트 컨트롤러
public class HomeController {

	@RequestMapping()
	public String main() {
		System.out.println("mainPage");
		
		return "home.index";
//		return "index"; -> /WEB-INF/view/index.jsp";
	}
	
//	@RequestMapping("main")
//	public String home() {
//		System.out.println("ㅎㅇㅎㅇ");
//		return "home.main";
//	}
	
	
	@RequestMapping("chat")
	public String chat() {
		return "home.chat";
	}
	
}
