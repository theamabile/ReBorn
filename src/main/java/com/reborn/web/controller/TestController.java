package com.reborn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.service.shelter.ShelterService;

@RestController()
@RequestMapping("/")
public class TestController {

	@Autowired
	private ShelterService service;
	
	@RequestMapping("test")
	public String test() {
		
		return "connectText Table record count: " + service.test();
//		return 13841079;
	}
	
}
