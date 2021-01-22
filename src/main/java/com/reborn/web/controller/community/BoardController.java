package com.reborn.web.controller.community;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardCategory;
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
		@RequestParam(name="v", defaultValue = "10") int view,		
		@RequestParam(name="f", defaultValue ="title") String field,
		@RequestParam(name="q", defaultValue = "") String query, 
		@RequestParam(name="c", defaultValue = "") String option,
		Model model) {
		
		List<BoardView> list = service.getViewList(page, view, field, query, option);
		System.out.println(page + ","+ view +","+field+","+query+","+option);
		int count = service.getCount(field, query);
		
		//int size = view;
		int pageCount = (int)Math.ceil(count/(float)view);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		
		return "home.community.list";
	}
	
	@RequestMapping("{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		
		BoardView board = service.get(id);
		
		model.addAttribute("b", board);
		
		
		return "home.community.datail";
		
	}
	@GetMapping("reg")
	public String reg() {
		
		return "home.community.reg";
	}
	
	@PostMapping("reg")
	public String reg(Board board, BoardCategory category, Member member, Principal principal) {
		String uid = principal.getName();
		int id = Integer.parseInt(uid);
		board.setId(id);
		
		return "redirect:list";
	}
	
	
	
}
