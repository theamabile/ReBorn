package com.reborn.web.dao.mybatis.report;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.report.ReportDao;
import com.reborn.web.entity.report.Missing;
import com.reborn.web.entity.report.MissingBoardView;
import com.reborn.web.entity.report.MissingComment;
import com.reborn.web.entity.report.MissingCommentView;
import com.reborn.web.entity.report.MissingView;

@Repository
public class MyBatisReportDao implements ReportDao{
	private ReportDao mapper;
	
	@Autowired
	public MyBatisReportDao(SqlSession session) {
		mapper = session.getMapper(ReportDao.class);
	}
	
	
	@Override
	public List<MissingBoardView> getViewList(int offset, int size) {
		// TODO Auto-generated method stub
		return mapper.getViewList(offset, size, "title", "");
	}
	
	@Override
	public List<MissingBoardView> getViewList(String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getViewList(0, 6, field, query);
	}
	
	@Override
	public List<MissingBoardView> getViewList(int offset, int size, String field, String query) {
		return mapper.getViewList(offset, size, field, query);
	}

	@Override
	public int getCount(String field, String query) {
		System.out.println(field);
		System.out.println(query);
		return mapper.getCount(field, query);
	}



	@Override
	public MissingView getView(int id) {
		// TODO Auto-generated method stub
		return mapper.getView(id);
	}


	@Override
	public List<MissingCommentView> getCommentViewList(int id) {
		// TODO Auto-generated method stub
		return mapper.getCommentViewList(id);
	}
	
	
	
	@Override
	public int insert(Missing missing) {
		// TODO Auto-generated method stub
		return mapper.insert(missing);
	}


	@Override
	public int insertComment(MissingComment missingComment) {
		// TODO Auto-generated method stub
		return mapper.insertComment(missingComment);
	}


	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return mapper.getLastId();
	}


	@Override
	public List<String> getEmailList() {
		// TODO Auto-generated method stub
		return mapper.getEmailList();
	}


	@Override
	public int commentDelete(int id) {
		// TODO Auto-generated method stub
		return mapper.commentDelete(id);
	}


	@Override
	public int commentDeclare(int memberId, int commentId, String reason) {
		// TODO Auto-generated method stub
		return  mapper.commentDeclare(memberId, commentId, reason);
	}


	@Override
	public int commentModify(int memberId, int commentId, String content) {
		// TODO Auto-generated method stub
		return mapper.commentModify(memberId, commentId, content);
	}


	@Override
	public int update(Missing missing) {
		return mapper.update(missing);
	}


	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}





}
