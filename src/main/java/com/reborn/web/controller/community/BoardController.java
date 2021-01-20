package com.reborn.web.controller.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reborn.web.entity.community.BoardView;
import com.reborn.web.service.community.BoardService;

@Controller
@RequestMapping("/community")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("list")
	public String list(
		@RequestParam(name="p", defaultValue ="1") int page,
		@RequestParam(name="f", defaultValue ="title") String field,
		@RequestParam(name="q", defaultValue = "") String query, Model model) {
		
		List<BoardView> list = service.getViewList(page, 10, field, query);
		int count = service.getCount(field, query);
		
		int size = 10;
		int pageCount = (int)Math.ceil(count/(float)size);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		
		return "home.community.list";
	}
}
