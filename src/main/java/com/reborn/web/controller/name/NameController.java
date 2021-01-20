package com.reborn.web.controller.name;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/* 이름 짓기 및 이름 선택(투표) */

@Controller
@RequestMapping("/name/")
public class NameController {
	
	// 이름 투표 목록
	@GetMapping("list")
	public String list() {
		
		return "home.name.list";
	}
	
	// 이름 투표
	@GetMapping("{id}")
	public String choice(@PathVariable(name="id")int id) {
		
		System.out.println("id : "+id);
		return "home.name.detail";
	}
	
	// 이름 짓기
	@GetMapping("{id}/add")
	public String add(@PathVariable(name="id")int id) {
		
		System.out.println("id : "+id);
		
		// redirect:../id
		return "home.name.add";
	}
	
	
}
