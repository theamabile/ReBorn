package com.reborn.web.dao.chat;

import java.util.List;

import com.reborn.web.entity.chat.Chatting;

public interface ChatDao {

	int sendMsg(int userId, String chatData, int roomId);

	List<Chatting> getList(int id);

}
