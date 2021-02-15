package com.reborn.web.dao.mybatis.name;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.name.ChoiceDao;
import com.reborn.web.dao.name.NameDao;
import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.VoteView;

@Repository
public class MyBatisChoiceDao implements ChoiceDao{

	private SqlSession session;
	private ChoiceDao mapper;

	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
		this.mapper = session.getMapper(ChoiceDao.class);
	}
	
	@Override
	public int insert(Choice choice) {
		// TODO Auto-generated method stub
		return mapper.insert(choice);
	}

	@Override
	public int update(Choice choice) {
		// TODO Auto-generated method stub
		return mapper.update(choice);
	}

	@Override
	public int delete(long animalId, int memberId) {
		// TODO Auto-generated method stub
		return mapper.delete(animalId, memberId);
	}

	@Override
	public Choice get(long animalId, int memberId) {
		// TODO Auto-generated method stub
		return mapper.get(animalId, memberId);
	}

	@Override
	public List<Choice> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public List<Long> getChoicedIdsByMemberId(int memberId, List<VoteView> list) {
		// TODO Auto-generated method stub
		return mapper.getChoicedIdsByMemberId(memberId, list);
	}


}
