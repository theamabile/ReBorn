package com.reborn.web.controller.admin.data;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.reborn.web.entity.data.Info;
import com.reborn.web.service.data.DataService;


@Controller("adminInfomationController")
@RequestMapping("/admin/data/")
public class InfomationController {
	
	
	@Autowired
	private DataService service;
	
	@RequestMapping("reg")
	public String list() {
		
		return "admin.data.write";
	}
	
	
	@PostMapping("write")
	public String list(
			@RequestParam(name="title", required = false) String title,
			@RequestParam(name="category", required = false) int infoCategoryId,
			@RequestParam(name="content", defaultValue = "") String content
			) {
			int memberId = 1;
			System.out.println("aaa");
			System.out.println("title :" + title);
			System.out.println("infoCatecoryId :" + infoCategoryId);
			System.out.println("content :" + content);
			
			Info info = new Info(title, content, infoCategoryId, memberId);
			
			
			int result = service.write(info);
			
		return "redirect:/data/information";
	}
	
	

}
