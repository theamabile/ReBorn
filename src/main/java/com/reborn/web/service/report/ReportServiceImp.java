package com.reborn.web.service.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.report.ReportDao;

@Service
public class ReportServiceImp implements ReportService {
	@Autowired
	private ReportDao reportDao;
	
}
