package com.reborn.web.controller.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reborn.web.service.report.ReportService;

@Controller
@RequestMapping("/report/")
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	@RequestMapping("list")
	public String MissingBoard() {
		return "home.report.list";
	}
	
	
	@RequestMapping("write")
	public String MissingBoardWriter() {
		return "home.report.write";
	}
	
	
	@RequestMapping("detail")
	public String MissingBoardDetail() {
		return "home.report.detail";
	}
	
	
	@RequestMapping("edit")
	public String MissingBoardEdit() {
		return "home.report.edit";
	}
}