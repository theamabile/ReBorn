package com.reborn.web.service.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.reborn.web.dao.community.BoardDao;
import com.reborn.web.dao.community.CommentDao;
import com.reborn.web.dao.community.LikeDao;
import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardCategory;
import com.reborn.web.entity.community.BoardView;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;
import com.reborn.web.entity.community.Like;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private LikeDao likeDao;
	
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
	
	
	//트랜잭션 처리
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardView hitUp(int id) {
//		Board board = boardDao.get(id);
//		board.setHitCnt(board.getHitCnt()+1);
//		int result = boardDao.update(board);
		boardDao.hitUp(id);
		
		return boardDao.get(id);
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

//	@Override
//	public int getLastId() {
//		Board b = boardDao.getLast();
//		
//		return b.getId();
//	}
	//board의 마지막 Id값구하기
	@Override
	public Board getLastId() {
		
		return boardDao.getLast();
	}
	

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return boardDao.getCount(field, query);
	}
	
	@Override
	public int getCount(String field, String query, String option) {
		
		return boardDao.getCount(field, query, option);
	}

	@Override
	public Board getPrev(int id) {
		
		return boardDao.getPrev(id);
	}

	@Override
	public Board getNext(int id) {
		return boardDao.getnext(id);
	}
//	댓글 조회
	@Override
	public List<CommentView> getCommentViewList(int id) {
	
		return commentDao.getViewList(id);
	}
	
	//댓글 등록
	@Override
	public int commentInsert(Comment comment) {
		
		return commentDao.insert(comment);
		
	}
	@Override
	public int commentDelete(int id) {

		return commentDao.delete(id);
	}
		
	
	@Override
	public int getCommentCount(int id) {
		
		return commentDao.getCount(id);
	}
	
	@Override
	public int update(Comment comment) {
		int result = 0;
		commentDao.update(comment);
		return result;
	}
	
	
	@Override
	public int getLikeCount(int id) {
		// TODO Auto-generated method stub
		return likeDao.getLikeCount(id);
	}
	@Override
	public void insert(Like like) {	
		
		likeDao.insert(like);
	}
	
	@Override
	public int getCount(int id, int memberId) {
		
		return likeDao.getCount(id, memberId);
	}
	
	@Override
	public void delete(int id, int memberId) {
			likeDao.delete(id, memberId);
		
	}
	
	
	@Override
	public Comment commentGet(int id) {
		// TODO Auto-generated method stub
		return commentDao.commentGet(id);
	}
	
}
