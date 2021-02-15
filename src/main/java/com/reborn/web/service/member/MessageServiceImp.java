package com.reborn.web.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.member.MessageDao;
import com.reborn.web.entity.member.Message;
import com.reborn.web.entity.member.MessageView;
@Service
public class MessageServiceImp implements MessageService {

	@Autowired
	MessageDao messageDao; 
	
	@Override
	public Message get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> receive(int id) {

		return messageDao.getReceive(id);
	}

	@Override
	public List<MessageView> getReceiveList(int id, int page, int size, String field, String query) {
		
		int offset= (page-1)*size;
		return messageDao.getReceiveList(id,offset,size,field,query);
	}

	@Override
	public int getReceiveCount(int id, String field, String query) {
		// TODO Auto-generated method stub
		return messageDao.getReceiveCount(id,field,query);
	}

}
