package com.reborn.web.dao.mybatis.community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.community.CommentDao;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;

@Repository
public class MyBatisCommentDao implements CommentDao{

	private SqlSession session;
	
	private CommentDao mapper;
	
	@Autowired
	public MyBatisCommentDao(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(CommentDao.class);
	}
	
	
	@Override
	public List<CommentView> getViewList(int boardId) {
		return mapper.getViewList(boardId);
	}

	@Override
	public int insert(Comment commemt) {
	
		return mapper.insert(commemt);
	}

	@Override
	public int update(Comment commemt) {
	
		return mapper.update(commemt);
	}

	@Override
	public int delete(int id) {
			
		return mapper.delete(id);
	}


	@Override
	public int getCount(int id) {

		return mapper.getCount(id);
	}

	@Override
	public Comment commentGet(int id) {
	
		return mapper.commentGet(id);
	}
	
	
}
