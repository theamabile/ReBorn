package com.reborn.web.controller.api.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.entity.member.Message;
import com.reborn.web.service.member.MessageService;

@RestController("apiMessageController")
@RequestMapping("/api/message/")
public class MessageController {
	
	@Autowired
	MessageService service;

	@GetMapping("list")
	public Map<String,Object> list(HttpServletRequest req,
			@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "f", required = false) String field,
			@RequestParam(name = "q", defaultValue = "") String query) {
		
		
//		HttpSession session = req.getSession();
//		int id = (Integer)session.getAttribute("id");
//		
//		System.out.println("page:"+page);
//		System.out.println("query: "+query);
//		List<Message> list = service.getReceiveList(id,page, 10, field, query);
//		
//		int count = service.getReceiveCount(id,field, query);
		
		Map<String,Object> dto = new HashMap<>();
//		dto.put("list", list);
//		dto.put("count",count);
		
		return 		dto;
	}
	
}
