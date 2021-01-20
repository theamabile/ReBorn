package com.reborn.web.controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reborn.web.service.community.BoardService;

@Controller
@RequestMapping("/community")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("list")
	public String list() {
		
		return "home.community.list";
	}
}
