package com.reborn.web.dao.mybatis.community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.reborn.web.dao.community.BoardDao;
import com.reborn.web.entity.community.Board;
@Repository
public class MyBatisBoardDao implements BoardDao{
	
	@Autowired
	private SqlSession session;
	
	private BoardDao mapper;
	
	@Autowired
	public MyBatisBoardDao(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(BoardDao.class);
	}
	
	@Override
	public int insert(Board board) {
		return mapper.insert(board);
	}

	@Override
	public int update(Board board) {
		return mapper.update(board);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public Board get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<Board> getList() {
		return mapper.getList();
	}

	@Override
	public List<Board> getList(int offset) {
		return mapper.getList(1);
	}

	@Override
	public List<Board> getList(int offset, int size, String field, String query) {
		return mapper.getList(offset, size, field, query);
	}

	@Override
	public Board getLast() {

		return null;
	}

	@Override
	public int getCount(String field, String query) {
	
		return mapper.getCount(field, query);
	}

	@Override
	public Board getPrev(int id) {
		// TODO Auto-generated method stub
		return mapper.getPrev(id);
	}

	@Override
	public Board getnext(int id) {
		return mapper.getnext(id);
	}
	
	
}
