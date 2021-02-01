package com.reborn.web.controller.report;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.reborn.web.entity.report.Missing;
import com.reborn.web.entity.report.MissingBoardView;
import com.reborn.web.entity.report.MissingCommentView;
import com.reborn.web.entity.report.MissingView;
import com.reborn.web.service.email.EmailUtil;
import com.reborn.web.service.email.MailClient;
import com.reborn.web.service.report.ReportService;
import com.reborn.web.service.thread.AsyncService;

@Controller
@RequestMapping("/report/")
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	//메일
	//@Autowired
	//private EmailUtil emailUtil;
	
	//메일2(템플릿)
	//@Autowired
	//private MailClient mailClient;
	
	//스레드
	@Autowired
    AsyncService asyncService;
	
	
	@RequestMapping("list")
	public String MissingBoard(
			@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "f", required = false) String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model){

			int size = 6;
			List<MissingBoardView> list = service.getViewList(page, size, field, query);
			
			//이미지 추출
			for(MissingBoardView n: list) {
				String files = n.getFiles();
				if(files != null) {
					String [] fileArr = files.split(",");
					n.setFiles(fileArr[0]);
				}
			}
			model.addAttribute("list", list);
			
			int count = service.getCount(field, query);
			int pageCount = (int) Math.ceil(count /(float)size); 
			if(pageCount==0) {
				pageCount = 1;
			}
			model.addAttribute("pageCount", pageCount);
			
			
		return "home.report.list";
	}
	
	
	@GetMapping("write")
	public String MissingBoardWriter() {
		return "home.report.write";
	}
	
	
	
	

	@PostMapping("write")
	//@ResponseBody
	public String MissingBoardWriter(
			MultipartHttpServletRequest mtfRequest,
			@RequestParam(name="title", required = false) String title,
			@RequestParam(name="missing-date") String date,
			@RequestParam(name="location", required = false) String location,
			@RequestParam(name="breed", defaultValue = "") String breed,
			@RequestParam(name="feature", defaultValue = "") String feature,
			//@RequestParam(name="file", required = false) String files,
			@RequestParam(name="content", defaultValue = "") String content
			) throws IllegalStateException, IOException {
	
		//임시지정 memid;
		int memberId = 1;
		
		
		List<String> fileNames = new ArrayList(); //파일이름 담기.
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		for (MultipartFile mf : fileList) {
			String fileName = mf.getOriginalFilename();//원본 파일 이름
			if(fileName !="" && fileName != null) {
				System.out.println("fileName : " + fileName);
				fileNames.add(fileName);
			}
		}

		String files = null;
		files = String.join(",", fileNames); //arrayList -> 문자형으로 변환
		System.out.println(date);
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date missingDate = null;
		try {
			missingDate = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		System.out.println("aaa1" + files);
		System.out.println("aaa2" + missingDate);
		Missing missing = new Missing(memberId, title, content, missingDate, feature, location, breed, files);
		
		service.insert(missing);
		
		int id = service.getLastId();
		System.out.println("id :"  + id);
		
		
		
		String url = "/upload/report/" + id;
		String realPath = mtfRequest.getServletContext().getRealPath(url);
		System.out.println("mtfRequest" + mtfRequest);
		System.out.println("realPath : " + realPath);//저장경로
		
		//다중파일 업로드
		for (MultipartFile mf : fileList) {
			String fileName = mf.getOriginalFilename();//원본 파일 이름
			if(fileName !="" && fileName != null) {
			
				File realPathFile = new File(realPath); 
				if(!realPathFile.exists()) {
					realPathFile.mkdirs();
				}
				String uploadedFilePath = realPath + File.separator + mf.getOriginalFilename();
				File uploadedFile = new File(uploadedFilePath);
				mf.transferTo(uploadedFile);
				System.out.println("업로드 성공");
			}
		}


		 
		//
	    //System.out.println("realPath : "+realPath);
	    //System.out.println(files);

		//System.out.println("file : "+file);
		 
		/*
		 * File realPathFile = new File(realPath); if(!realPathFile.exists())
		 * realPathFile.mkdirs(); String uploadedFilePath = realPath + File.separator +
		 * file.getOriginalFilename(); File uploadedFile = new File(uploadedFilePath);
		 * file.transferTo(uploadedFile);
		 */
		
		String subject = "[리본]실종신고 글이 게시되었습니다 (" + title + ")";
		List<String> emailList= service.getEmailList();
		
		
		for(String email : emailList) {	
			asyncService.send(email, subject ,title, location, feature, id);
			//mailClient.prepareAndSend(email, subject ,title, location, feature, id);
		}
		
		//방법2이메일 보내기 (보내는 사람, 제목, 내용)
		//emailUtil.sendEmail("hyk1272@gmail.com", "제목넣는곳")" , "내용넣는곳");
		return "redirect:./"+id;
	}
	

	
	private Date DateFormat(String date) {
		// TODO Auto-generated method stub
		return null;
	}


	@RequestMapping("{id}")
	public String MissingBoardDetail(@PathVariable("id") int id, Model model) {
		MissingView missingView = service.getView(id);
		List<MissingCommentView> commentList = service.getCommentViewList(id);
		System.out.println(missingView.toString());
		model.addAttribute("missingView", missingView);
		model.addAttribute("commentList", commentList);
		
		return "home.report.detail";
	}
	
	
	@RequestMapping("edit")
	public String MissingBoardEdit() {
		return "home.report.edit";
	}
}