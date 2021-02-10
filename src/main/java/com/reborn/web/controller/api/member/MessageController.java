package com.reborn.web.controller.api.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.entity.member.Message;
import com.reborn.web.service.member.MessageService;

@RestController("apiMessageController")
@RequestMapping("/api/message/")
public class MessageController {
	
	@Autowired
	MessageService service;

	@GetMapping("list")
	public List<Message> list(HttpServletRequest req) {
		
		
		HttpSession session = req.getSession();
		int id = (Integer)session.getAttribute("id");
		
		return 		service.receive(id);
	}
	
}
