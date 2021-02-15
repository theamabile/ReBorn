package com.reborn.web.dao.member;

import java.util.List;

import com.reborn.web.entity.member.Member;
import com.reborn.web.entity.member.Message;
import com.reborn.web.entity.member.MessageView;

public interface MessageDao {

	List<Message> getReceive(int id);

	List<MessageView> getReceiveList(int id, int offset,int size, String field, String query);


	int getReceiveCount(int id, String field, String query);

	


}
