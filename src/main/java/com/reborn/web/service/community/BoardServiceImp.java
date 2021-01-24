package com.reborn.web.service.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.community.BoardDao;
import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardCategory;
import com.reborn.web.entity.community.BoardView;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> getList(int page, int size, String field, String query) {
		int startIndex = 1+(page-1)*size;
		int endIndex = page*10;
		int offset = (page-1)*10;
		
		return boardDao.getList(startIndex, endIndex, field, query);
	}
	@Override
	public List<BoardView> getViewList(int page, int size) {
		int offset = (page-1)*10;
		return boardDao.getViewList(offset, size);
	}
	
	@Override
	public List<BoardView> getViewList(int page, int size, String field, String query) {
		
		int offset = (page-1)*10;
		
		return boardDao.getViewList(offset, size, field, query);
	}
	
	@Override
	public List<BoardView> getViewList(int page, int view, String field, String query, String option) {
		
		int offset = (page-1)*10;
		
		return boardDao.getViewList(offset, view, field, query, option);
	}

	

	@Override
	public int hitUp(int id) {
		Board board = boardDao.get(id);
		board.setHitCnt(board.getHitCnt()+1);
		int result = boardDao.update(board);
		return result;
	}

	@Override
	public BoardView get(int id) {
		return boardDao.get(id);
	}

	@Override
	public int insert(Board board) {
		return boardDao.insert(board);
	}
	
	@Override
	public int insert(BoardCategory category) {
		// TODO Auto-generated method stub
		return boardDao.insert(category);
	}

	@Override
	public int update(Board board) {
		int result = 0;
		result = boardDao.update(board);
		return result;
	}

	@Override
	public int delete(int id) {
		int result = 0;
		result = boardDao.delete(id);
		return result;
	}

	@Override
	public int getLastId() {
		Board b = boardDao.getLast();
		
		return b.getId();
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return boardDao.getCount(field, query);
	}

	@Override
	public Board getPrev(int id) {
		
		return boardDao.getPrev(id);
	}

	@Override
	public Board getNext(int id) {
		return boardDao.getnext(id);
	}


	
	
}
