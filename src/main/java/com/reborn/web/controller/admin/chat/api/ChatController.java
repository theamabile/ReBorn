package com.reborn.web.controller.admin.chat.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.entity.chat.Link;
import com.reborn.web.service.chat.ChatService;


@RestController("apiAdminChatController")
@RequestMapping("/api/admin/chat/")
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	
	
	@RequestMapping("link/list")
	public List<Link> list() {
		System.out.println("aa");
		List<Link> linkList= chatService.getLinkList();
		return linkList;
		
	}
	
	@PostMapping("link/add")
	public int addLink(
			@RequestParam(name="title", defaultValue="1") String title,
			@RequestParam(name="link", defaultValue="1") String address) {
		
			int result = chatService.addLink(title, address);
			System.out.println(result);
		return result;
	}
	
	
	@RequestMapping("link/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		int result = chatService.linkDelete(id);
		//System.out.println("삭제완료");
		
	}
}
