package com.reborn.web.controller.admin.data.api;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@RestController("apiAdminInfomationController")
@RequestMapping("/api/admin/data/")
public class InfomationController {

	

	@PostMapping("upload")
	public String upload(
			MultipartHttpServletRequest request
			) throws Exception{
		//System.out.println(request.getAttribute("imageFile"));
		
		
		List<String> fileNames = new ArrayList(); //파일이름 담기.
		List<MultipartFile> fileList = request.getFiles("imageFile");
		for (MultipartFile mf : fileList) {
			String fileName = mf.getOriginalFilename();//원본 파일 이름
			if(fileName !="" && fileName != null) {
				//System.out.println("fileName : " + fileName);
				fileNames.add(fileName);
			}
		}
		
		
		int max = 10000;
		int random = (int)(Math.random() * max);
		
		
		String url =  File.separator +"upload" + File.separator + "admin" + File.separator + "data" +File.separator + "random" ;
		String path = null;
		String realPath = request.getServletContext().getRealPath(url);
		//System.out.println("mtfRequest" + request);
		//System.out.println("realPath : " + realPath);//저장경로
		
		//System.out.println(fileList);
		
		String uploadedFilePath = null;
	   for (MultipartFile mf : fileList) {
			String fileName = mf.getOriginalFilename();//원본 파일 이름
			if(fileName !="" && fileName != null) {
				
				File realPathFile = new File(realPath); 
				if(!realPathFile.exists()) {
				realPathFile.mkdirs();
				}
				path = url + File.separator + fileName;
				uploadedFilePath = realPath + File.separator + mf.getOriginalFilename();
				File uploadedFile = new File(uploadedFilePath);
				mf.transferTo(uploadedFile);
				//System.out.println("uploadedFilePath" + uploadedFilePath);
				//System.out.println("업로드 성공");
			}

		}
	  // System.out.println("uploadedFilePath :" + uploadedFilePath);
	   //System.out.println(path);
	   //model.addAttribute("path", uploadedFilePath);
	return path;

	}
}
