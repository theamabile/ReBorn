package com.reborn.web.dao.mybatis.report;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.report.ReportDao;

@Repository
public class MyBatisReportDao implements ReportDao{
	private ReportDao mapper;
	
	@Autowired
	public MyBatisReportDao(SqlSession session) {
		mapper = session.getMapper(ReportDao.class);
	}
}
