package com.reborn.web.controller.member;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reborn.web.entity.member.Member;
import com.reborn.web.entity.member.MessageView;
import com.reborn.web.service.member.MemberService;
import com.reborn.web.service.member.MessageService;

@Controller
@RequestMapping("/member/info/")
public class MemberInfoController {

	@Autowired
	MemberService memberService;
	@Autowired
	MessageService messageService;

	// 회원가입
	@GetMapping("join")
	public String join() {
		return "home.member.join";
	}

	@PostMapping("join")
	public String join(Member m, @RequestParam(value = "year", defaultValue = "2000") String year,
			@RequestParam(value = "month", defaultValue = "1") String month,
			@RequestParam(value = "day", defaultValue = "1") String day, String emailId, String emailAddress,
			String customAddress) {

		// birthDay 형 변환
		String date = year + "-" + month + "-" + day;
		Date d = Date.valueOf(date);
		System.out.println(emailAddress);

//		email 
		String email;
		if (!emailAddress.equals("none"))
			email = emailId + "@" + emailAddress;
		else
			email = emailId + "@" + customAddress;

		m.setEmail(email);
		m.setBirthDay(d);
		m.setAuthorityId(2); // 회원으로 등록

		memberService.insert(m);
		return "redirect:../login";
	}
	
	
	@GetMapping("/message")
	public String message(HttpServletRequest req,
			@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "f", required = false) String field,
			@RequestParam(name = "q", defaultValue = "") String query,Model model) {
		
		HttpSession session = req.getSession();
		int id = (Integer)session.getAttribute("id");
		

		List<MessageView> list = messageService.getReceiveList(id,page, 10, field, query);
		
		int count = messageService.getReceiveCount(id,field, query);
		
//		Map<String,Object> dto = new HashMap<>();
//		dto.put("list", list);
//		dto.put("count",count);
		int pageCount=(int) Math.ceil(count/ (float)10);
		System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		
		return "home.member.message";
	}


}