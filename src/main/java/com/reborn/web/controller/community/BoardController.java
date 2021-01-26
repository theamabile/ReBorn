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
import com.reborn.web.entity.community.CommentView;
import com.reborn.web.service.community.BoardService;

@Controller
@RequestMapping("/community")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//글 리스트
	@RequestMapping("list")
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
		
		return "home.community.list";
	}
	//글 상세
	@RequestMapping("{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		
		BoardView board = service.get(id);		
		model.addAttribute("b", board);
		
		List<CommentView> comment = service.getCommentViewList(id);
		model.addAttribute("comment", comment);
		
		int commentCount = service.getCommentCount(id);
		model.addAttribute("commentCount", commentCount);
		
		return "home.community.detail";		
	}
	//글 수정 요청
	@GetMapping("{id}/edit")
	public String edit(Model model, @PathVariable("id") int id) {
		
		BoardView board = service.get(id);
		model.addAttribute("b", board);
		
		return "home.community.edit";
	}
	
	//글 수정 Post
	@PostMapping("{id}/edit")
	public String edit(Board board, @RequestParam(name="category", defaultValue ="1") int category) {
		int id = board.getId();
		String title = board.getTitle();
		String content = board.getContent();
		
		
		Board origin = service.get(board.getId());
		origin.setTitle(title);
		origin.setContent(content);
		origin.setBoardCategoryId(category);
		System.out.println(content + "/" + category);
		System.out.println(board.getId());
		service.update(origin);
		
		return "redirect:../"+board.getId();
	} 
	
	
	
	//글 삭제
	@RequestMapping("{id}/del")
	public String delete(@PathVariable("id") int id) {
		System.out.println("========="+id);
		service.delete(id);
		
		return "redirect:../list";
		
	}
	
	//글 요청
	@GetMapping("reg")
	public String reg() {
		
		
		return "home.community.reg";
	}
	//글 등록
	@PostMapping("reg")
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
		
		return "redirect:list";
	}
	
	//댓글 삭제
	@RequestMapping("{id}/comment/{commentId}/del")
	public String commentDelete(@PathVariable("id") int id,
			@PathVariable("commentId") int commentId
			) {
		
		System.out.println(id);
		service.commentDelete(commentId);
		
		return "redirect:../../../"+id;
	}
	
	//댓글 작성
	@PostMapping("{id}/comment/write")
	public String commentWrite(
			@PathVariable("id") int id,
			@RequestParam(name="comment") String commentContent,			
			Principal principal
			) {
		Comment comment = new Comment();
		comment.setContent(commentContent);
		comment.setMemberId(1);
		comment.setBoardId(id);
		
		
		service.commentInsert(comment);
		return "redirect:../../"+id;
	
	}
	
	
	
	
}
