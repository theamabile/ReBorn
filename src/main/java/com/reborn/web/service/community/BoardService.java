package com.reborn.web.service.community;

import java.util.List;

import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardCategory;
import com.reborn.web.entity.community.BoardView;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;
import com.reborn.web.entity.community.Like;

public interface BoardService {
	
	int hitUp(int id);
	BoardView get(int id);
	int insert(Board board);
	int insert(BoardCategory category);
	
	int update(Board board);
	int delete(int id);
	Board getLastId(); 
//	int getLastId();
	int getCount(String field, String query);
	Board getPrev(int id);
	Board getNext(int id);
	List<Board> getList(int page, int size, String field, String query);
	List<BoardView> getViewList(int page, int size, String field, String query);
	List<BoardView> getViewList(int page, int size);
	List<BoardView> getViewList(int page, int view, String field, String query, String option);
	
	public int commentInsert(Comment comment);
	public int commentDelete(int id);
	int getCommentCount(int id);
	List<CommentView> getCommentViewList(int id);
	int update(Comment comment);
	int getLikeCount(int id);
	void insert(Like like);
	int getCount(int id, int memberId);
	void delete(int id, int memberId);
	
	Comment commentGet(int id);
}
