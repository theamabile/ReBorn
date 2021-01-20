package com.reborn.web.service.community;

import java.util.List;

import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardView;

public interface BoardService {
	
	int hitUp(int id);
	Board get(int id);
	int insert(Board board);
	int update(Board board);
	int delete(int id);
	int getLastId();
	int getCount(String field, String query);
	Board getPrev(int id);
	Board getNext(int id);
	List<Board> getList(int page, int size, String field, String query);
	List<BoardView> getViewList(int page, int size, String field, String query);
	List<BoardView> getViewList(int page, int size);
}
