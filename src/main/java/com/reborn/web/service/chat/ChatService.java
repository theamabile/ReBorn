package com.reborn.web.service.chat;

import java.util.List;

import com.reborn.web.entity.chat.Chatting;
import com.reborn.web.entity.chat.Room;

public interface ChatService {

	int sendMsg(int userId, String chatData, int roomId);
	List<Chatting> getList(int id);
	List<Integer> getRoomList();


}
