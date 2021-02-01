package com.reborn.web.service.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.report.ReportDao;
import com.reborn.web.entity.report.Missing;
import com.reborn.web.entity.report.MissingBoardView;
import com.reborn.web.entity.report.MissingComment;
import com.reborn.web.entity.report.MissingCommentView;
import com.reborn.web.entity.report.MissingView;

@Service
public class ReportServiceImp implements ReportService {
	@Autowired
	private ReportDao reportDao;


	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return reportDao.getCount(field, query);
	}
	
	
	@Override
	public List<MissingBoardView> getViewList(int page, int size) {
		int offset =  (page-1) * size;
		return reportDao.getViewList(offset, size);
	}
	
	@Override
	public List<MissingBoardView> getViewList(String field, String query) {
		return reportDao.getViewList(field, query);
	}
	
	
	@Override
	public List<MissingBoardView> getViewList(int page, int size, String field, String query) {
		int offset =  (page-1) * size;
		return reportDao.getViewList(offset, size, field, query);
	}


	@Override
	public MissingView getView(int id) {
		// TODO Auto-generated method stub
		return reportDao.getView(id);
	}


	@Override
	public List<MissingCommentView> getCommentViewList(int id) {
		// TODO Auto-generated method stub
		return reportDao.getCommentViewList(id);
	}
	
	
	
	@Override
	public int insert(Missing missing) {
		// TODO Auto-generated method stub
		return reportDao.insert(missing);
	}


	@Override
	public int insertComment(MissingComment missingComment) {
		// TODO Auto-generated method stub
		return  reportDao.insertComment(missingComment);
	}


	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return reportDao.getLastId();
	}


	@Override
	public List<String> getEmailList() {
		// TODO Auto-generated method stub
		return reportDao.getEmailList();
	}



	
}
