package com.reborn.web.service.member;

import java.util.List;

import com.reborn.web.entity.member.Message;
import com.reborn.web.entity.member.MessageView;

public interface MessageService {

	Message get(int id);

	List<Message> receive(int id);

	List<MessageView> getReceiveList(int id, int page, int size, String field, String query);

	int getReceiveCount(int id, String field, String query);
	
}
