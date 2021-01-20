package com.reborn.web.controller.animal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal/")
public class AnimalController {
	
	@RequestMapping("list")
	public String home() {
		System.out.println("ㅎㅇㅎㅇ");
		return "home.animal.list";
	}
}
