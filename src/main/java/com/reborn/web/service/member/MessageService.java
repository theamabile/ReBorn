package com.reborn.web.service.member;

import java.util.List;

import com.reborn.web.entity.member.Message;

public interface MessageService {

	Message get(int id);

	List<Message> receive(int id);
	
}
