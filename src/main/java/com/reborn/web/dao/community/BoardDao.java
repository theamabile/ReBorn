package com.reborn.web.dao.community;

import java.util.List;

import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardView;

public interface BoardDao {
	int insert(Board board);
	int update(Board board);
	int delete(int id);
	
	Board get(int id);
	
	Board getLast();
	
	//검색후 갯수를 반환: 인수는 getViewList와 동일하게.
	int getCount(String field, String query);
	
	//상세 페이지에서 이전/다음글을 구하기 위한 함수
	Board getPrev(int id);
	Board getnext(int id);
	
	List<Board> getList();	
	List<Board> getList(int offset);
	List<Board> getList(int offset, int size, String field, String query);
	List<BoardView> getViewList(int offset, int size, String field, String query);
	List<BoardView> getViewList(int offset, int size);
}
