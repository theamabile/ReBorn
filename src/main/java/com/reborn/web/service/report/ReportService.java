package com.reborn.web.service.report;

import java.util.List;

import com.reborn.web.entity.report.Missing;
import com.reborn.web.entity.report.MissingBoardView;
import com.reborn.web.entity.report.MissingComment;
import com.reborn.web.entity.report.MissingCommentView;
import com.reborn.web.entity.report.MissingView;

public interface ReportService {
	
	List<MissingBoardView> getViewList(int page, int size);
	List<MissingBoardView> getViewList(String field, String query);
	List<MissingBoardView> getViewList(int page, int size, String field, String query);

	int getCount(String field, String query);
	
	MissingView getView(int id);
	List<MissingCommentView> getCommentViewList(int id);
	
	int insert(Missing missing);
	int insertComment(MissingComment missingComment);
	int commentDelete(int id);
	int getLastId();
	List<String> getEmailList();
	int commentDeclare(int memberId, int commentId, String reason);
	int commentModify(int memberId, int commentId, String content);
	int update(Missing missing);
	int delete(int id);
	
	
	
	

}
