package com.reborn.web.service.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.chat.ChatDao;
import com.reborn.web.dao.mybatis.chat.MybatisChatDao;
import com.reborn.web.entity.chat.Chatting;
import com.reborn.web.entity.chat.Room;

@Service
public class ChatServiceImp implements ChatService{
	
	@Autowired
	private ChatDao chatDao;

	@Override
	public int sendMsg(int userId, String chatData, int roomId) {
		return  chatDao.sendMsg(userId, chatData, roomId);	
	}

	@Override
	public List<Chatting> getList(int id) {
		return chatDao.getList(id);
	}

	@Override
	public List<Integer> getRoomList() {
		return chatDao.getRoomList();
	}



}
