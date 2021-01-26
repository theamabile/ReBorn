package com.reborn.web.controller.api.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.entity.community.BoardView;
import com.reborn.web.service.community.BoardService;

@RestController("apiBoardController")
@RequestMapping("/api/community/")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("list")
	public List<BoardView> list(
			@RequestParam(name="p", defaultValue ="1") int page,
			@RequestParam(name="v", defaultValue = "10") int view,		
			@RequestParam(name="f", defaultValue ="title") String field,
			@RequestParam(name="q", defaultValue = "") String query, 
			@RequestParam(name="c", defaultValue = "", required = false) String option
			) {
		
		List<BoardView> list = service.getViewList(page, view, field, query, option);

			return list;
				
	}
}
