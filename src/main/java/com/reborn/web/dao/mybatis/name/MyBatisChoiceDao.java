package com.reborn.web.dao.mybatis.name;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.reborn.web.dao.name.ChoiceDao;
import com.reborn.web.entity.name.Choice;

@Repository
public class MyBatisChoiceDao implements ChoiceDao{

	@Override
	public int insert(Choice choice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Choice choice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Choice get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Choice> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Choice> getList(int offset, int size, String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Choice> getList(int startIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
