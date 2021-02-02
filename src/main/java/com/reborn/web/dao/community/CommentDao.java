package com.reborn.web.dao.community;

import java.util.List;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;

public interface CommentDao {
	// 댓글 조회
	List<CommentView> getViewList(int boardId);
	
	// 댓글 작성
	int insert(Comment commemt);
	
	// 댓글 수정
	int update(Comment commemt);
	
	// 댓글 삭제
	int delete(int id);

	int getCount(int id);

	Comment commentGet(int id);

	
	
}
