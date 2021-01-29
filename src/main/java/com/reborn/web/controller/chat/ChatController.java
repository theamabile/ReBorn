package com.reborn.web.controller.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.entity.chat.Chatting;
import com.reborn.web.service.chat.ChatService;


@RestController("apiChatController")
@RequestMapping("/api/chat/")
public class ChatController{
	@Autowired
	private ChatService service;
	
	@RequestMapping("list")
	public List<Chatting> list(
			@RequestParam(name = "id", defaultValue = "1") Integer id) {
		
		List<Chatting> list = service.getList(id);
		return list;
			
	}
}
