package com.reborn.web.service.community;

import java.util.List;

import com.reborn.web.entity.community.Board;

public interface BoardService {
	
	List<Board> getList(int page, int size, String field, String query);
	int hitUp(int id);
	Board get(int id);
	int insert(Board board);
	int update(Board board);
	int delete(int id);
	int getLastId();
	int getCount(String field, String query);
	Board getPrev(int id);
	Board getNext(int id);
	
}
