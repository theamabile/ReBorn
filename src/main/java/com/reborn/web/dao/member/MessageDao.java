package com.reborn.web.dao.member;

import java.util.List;

import com.reborn.web.entity.member.Member;
import com.reborn.web.entity.member.Message;

public interface MessageDao {

	List<Message> getReceive(int id);
	


}
