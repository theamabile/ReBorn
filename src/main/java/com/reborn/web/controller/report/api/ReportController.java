package com.reborn.web.controller.report.api;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.entity.report.MissingComment;
import com.reborn.web.entity.report.MissingCommentView;
import com.reborn.web.service.report.ReportService;

@RestController("apiReportController")
@RequestMapping("/api/report/")
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	
	
	@PostMapping("{id}/comment/write")
	public String write(
			@PathVariable("id") int missingId, 
			@RequestParam(name = "comment-content") String commetContent,
			HttpServletRequest HttpRquset) {
	
		HttpSession session = HttpRquset.getSession();
		int memberId = (int)session.getAttribute("id");

		String content = commetContent;
		System.out.println(content);
	
		MissingComment missingComment =  new MissingComment(memberId, missingId, content);
		service.insertComment(missingComment);
		return null;
	}
	
	
	@RequestMapping("comments/{id}")
	public List<MissingCommentView> CommentList(
			@PathVariable("id") int missingId
			) {
		List<MissingCommentView> commentList= service.getCommentViewList(missingId);
		
		return commentList;
	}
	
	//댓글삭제
	@RequestMapping("{id}/comment/delete/{comId}")
	public int CommentList(
			@PathVariable("id") int missingId,
			@PathVariable("comId") int id
			) {
		int result = service.commentDelete(id);
		return result;
	}
	
	
	//댓글신고
	@PostMapping("{id}/comment/declare/{comId}")
	public int declare(
			@PathVariable("comId") int commentId,
			@PathVariable("id") int missingId,
			@RequestParam(name = "reason") String reason,
			HttpServletRequest HttpRquset) {
		//임지작성String uid = principal.getId(); //로그인된사용자 정보
		HttpSession session = HttpRquset.getSession();
		int memberId = (int)session.getAttribute("id");

		int result = service.commentDeclare(memberId, commentId, reason);
		return result;
	}
	
	
	//댓글 수정
	@PostMapping("{id}/comment/modify/{comId}")
	public int modify(
			@PathVariable("comId") int commentId,
			@PathVariable("id") int missingId,
			@RequestParam(name = "content") String content,
			HttpServletRequest HttpRquset) {
		
		//임지작성String uid = principal.getId(); //로그인된사용자 정보
		HttpSession session = HttpRquset.getSession();
		int memberId = (int)session.getAttribute("id");
		System.out.println("1");
		int result = service.commentModify(memberId, commentId, content);
		System.out.println(result);
		return result;
	}
	
	
}
