package com.reborn.web.controller.report;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report/")
public class ReportController {
	
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