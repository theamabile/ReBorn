package com.reborn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.service.care.CareService;

@RestController()
@RequestMapping("/")
public class TestController {

//	@Autowired
//	private CareService service;
	
	@RequestMapping("test")
	public String test() {
		
//		return "connectText Table record count: " + service.test();
		return "test";
	}
	
}
