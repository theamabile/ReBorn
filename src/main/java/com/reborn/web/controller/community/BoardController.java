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
import com.reborn.web.entity.community.BoardView;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.service.community.BoardService;
import com.reborn.web.service.community.CommentService;

@Controller
@RequestMapping("/community")
public class BoardController {
	
	@Autowired
	private BoardService service;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("boardList")
	public String list(
		@RequestParam(name="p", defaultValue ="1") int page,
		@RequestParam(name="v", defaultValue = "10") int view,		
		@RequestParam(name="f", defaultValue ="title") String field,
		@RequestParam(name="q", defaultValue = "") String query, 
		@RequestParam(name="c", defaultValue = "", required = false) String option,
		Model model) {
		
		List<BoardView> list = service.getViewList(page, view, field, query, option);
		System.out.println(page + ","+ view +","+field+","+query+","+option);
		int count = service.getCount(field, query);
		
		//int size = view;
		int pageCount = (int)Math.ceil(count/(float)view);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		
		return "home.community.boardList";
	}
	
	@RequestMapping("{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		
		BoardView board = service.get(id);		
		model.addAttribute("b", board);
		
		List<Comment> comment = commentService.getList(id);
		model.addAttribute("comment", comment);
		
		
		return "home.community.boardDetail";		
	}
	
	@RequestMapping("{id}/del")
	public String delete(@PathVariable("id") int id) {
		service.delete(id);
		
		return "redirect:../boardList";
		
	}
	
	
	@GetMapping("boardReg")
	public String reg() {
		
		
		return "home.community.boardReg";
	}
	
	@PostMapping("boardReg")
	public String reg(@RequestParam(name="title") String title,
			@RequestParam(name="content") String content,
			@RequestParam(name="category") int category,
			@RequestParam(name="memberId", defaultValue = "1" ) int member,
			Principal principal) {
//		String uid = principal.getName();
//		int id = Integer.parseInt(uid);
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setBoardCategoryId(category);
		//멤버ID는 멤버가 주는 값으로 수정해야 함.		
		board.setMemberId(1);
		service.insert(board);
		
		return "redirect:boardList";
	}
	
	
	
}
