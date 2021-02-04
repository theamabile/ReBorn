package com.reborn.web.dao.mybatis.chat;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.chat.ChatDao;
import com.reborn.web.dao.data.DataDao;
import com.reborn.web.entity.chat.Chatting;
import com.reborn.web.entity.chat.Room;

@Repository
public class MybatisChatDao implements ChatDao {
	
	private ChatDao mapper;
	
	@Autowired
	public MybatisChatDao(SqlSession session) {
		mapper = session.getMapper(ChatDao.class);
	}
	

	@Override
	public int sendMsg(int userId, String chatData, int roomId) {
		return mapper.sendMsg(userId, chatData, roomId);
	}


	@Override
	public List<Chatting> getList(int id) {
		return mapper.getList(id);
	}


	@Override
	public List<Integer> getRoomList() {
		// TODO Auto-generated method stub
		return mapper.getRoomList();
	}

}
