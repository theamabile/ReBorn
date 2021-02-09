package com.reborn.web.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.member.MessageDao;
import com.reborn.web.entity.member.Message;
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

}
