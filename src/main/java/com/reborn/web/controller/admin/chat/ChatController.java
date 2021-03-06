package com.reborn.web.controller.admin.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reborn.web.entity.chat.Link;
import com.reborn.web.service.chat.ChatService;


@Controller("adminChatController")
@RequestMapping("/admin/chat/")
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	@RequestMapping("list")
	public String list(
			 Model model
			) {
		//List<Integer> roomList = new ArrayList();
		List<Integer> roomList = chatService.getRoomList();
		
		model.addAttribute("roomList", roomList);
		
		return "admin.chat.list";
	}
	
	
	@RequestMapping("link")
	public String link(
			 Model model
			 ) {
		List<Link> linkList = chatService.getLinkList();
		
		model.addAttribute("linkList", linkList);
		
		return "admin.chat.link";
	}


	private void getLinkList() {
		// TODO Auto-generated method stub
		
	}
}
