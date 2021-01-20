package com.reborn.web.controller.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data/")
public class InfoController {

	@RequestMapping("introduce")
	public String introduce() {
		return "home.data.introduce";
	}
	
	@RequestMapping("information")
	public String information() {
		return "home.data.information";
	}
	
	
	@RequestMapping("detail")
	public String informationDetail() {
		return "home.data.detail";
	}
}