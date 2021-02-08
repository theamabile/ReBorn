package com.reborn.web.controller.mypage;


import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.reborn.web.entity.member.Member;
import com.reborn.web.service.member.MemberService;
import com.reborn.web.service.member.TitleService;

@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	TitleService titleService;
	
	//패스워드 암호화 
	 private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	/*
	 * @Autowired HttpSession session = request.getSession();
	 */
	
	@GetMapping("info")
	public String info(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		String loginId = (String)session.getAttribute("loginId");
		
		Member m = memberService.get(loginId);
		int titleId= m.getTitleId();
		String title = titleService.get(titleId);
		
		model.addAttribute("m", m);
		model.addAttribute("title", title);
		
//		이메일
		List<String> addrList = new ArrayList<String>(); 
		addrList.add("naver.com");
		addrList.add("daum.net");
		addrList.add("gmail.com");
		
		String[] emailStrs = m.getEmail().split("@");  
		int result = addrList.indexOf(emailStrs[1]);
		System.out.println(result);
		if(result < 0 ) {
			model.addAttribute("isCustomAddr", true);
		} else {
			model.addAttribute("isCustomAddr", false);
		}			

		model.addAttribute("emailId", emailStrs[0]);
		model.addAttribute("emailAddress", emailStrs[1]);

		
	
		return "home.mypage.info";
	}
	
	//회원 수정 
	@PostMapping("info")
	public String info(Member m, @RequestParam(value = "year", defaultValue = "2000") String year,
			@RequestParam(value = "month", defaultValue = "1") String month,
			@RequestParam(value = "day", defaultValue = "1") String day, String emailId, String emailAddress,
			String customAddress, HttpServletRequest req) {
		
		
		//이메일
		if(emailAddress.equals("none") == true) {
			emailAddress = customAddress;
		}
		String email = emailId + "@" + emailAddress;
		
		// birthDay 형 변환
		String date = year + "-" + month + "-" + day;
		Date d = Date.valueOf(date);
		
		HttpSession session = req.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		Member member= memberService.get(loginId);
		
		
		//패스워드 암호화 
		String encodePassword = passwordEncoder.encode(m.getPw());
		
		
		member.setLoginId(m.getLoginId());
		member.setName(m.getName());
		member.setGender(m.getGender());
		member.setPw(encodePassword);
		member.setNickname(m.getNickname());
		member.setPhone(m.getPhone());
		member.setAuthorityId(2);
		
		member.setEmail(email);
		member.setBirthDay(d);
		
		memberService.update(member);
		System.out.println(member);
		return "redirect:./info";
	}

	@GetMapping("imgInput")
	public String imgInput(Model model,HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		Member m = memberService.get(loginId);

	
		model.addAttribute("m", m);
		
		return "home.mypage.imgInput";
	}
	
	@PostMapping("img-update")
	@ResponseStatus(HttpStatus.CREATED)
	public String imgInput(@RequestParam("file") MultipartFile file,HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		Member m = memberService.get(loginId);

		
		
		String fileName = file.getOriginalFilename();//원본 파일 이름
		if(fileName !="" && fileName != null) {
			System.out.println("fileName : " + fileName);
		}
		
		String url = "/upload/member/profile/" + m.getId();
		String realPath = req.getServletContext().getRealPath(url);
		System.out.println("realPath : " + realPath);//저장경로
		
		//디렉토리 생성
		File path = new File(realPath); 
		if(!path.exists()) {
			path.mkdirs();
		}
		
		String filePath = realPath + File.separator + fileName;
		File uploadedFile = new File(filePath);
		System.out.println("filePath : "+filePath);  // 전송된 파일의 이름 갖고오기
		
		
		try {
			file.transferTo(uploadedFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		m.setProfileImg(fileName);
		System.out.println(fileName);
		memberService.update(m);
		
		return "redirect:../main";
	}
	
	
}
