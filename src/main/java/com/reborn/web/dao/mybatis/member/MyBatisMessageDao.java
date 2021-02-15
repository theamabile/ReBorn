package com.reborn.web.dao.mybatis.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.member.MemberDao;
import com.reborn.web.dao.member.MessageDao;
import com.reborn.web.entity.member.Member;
import com.reborn.web.entity.member.Message;
import com.reborn.web.entity.member.MessageView;

@Repository
public class MyBatisMessageDao implements MessageDao {

	private SqlSession session;
	private MessageDao mapper;

	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
		this.mapper = session.getMapper(MessageDao.class);
	}

	@Override
	public List<Message> getReceive(int id) {
		// TODO Auto-generated method stub
	
		return mapper.getReceive(id);
	}


	@Override
	public List<MessageView> getReceiveList(int id, int offset, int size, String field, String query) {
		// TODO Auto-generated method stub
System.out.println("field: "+field+"query: "+query);
		
		return  mapper.getReceiveList(id,offset,size, field,query);
	}

	@Override
	public int getReceiveCount(int id, String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getReceiveCount(id,field,query);
	}	

}
