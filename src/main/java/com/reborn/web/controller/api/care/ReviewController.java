package com.reborn.web.controller.api.care;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.entity.care.CareReview;
import com.reborn.web.service.care.CareService;

@RestController("apiReviewController")
@RequestMapping("/api/care/review")
public class ReviewController {

	private CareService careService;
	// ============================================================
	// ============================================================
	// 테스트용 아이디, careService에서도 있음
	private int memberId = 3;
	// ============================================================
	// ============================================================
	
	@Autowired
	public ReviewController(CareService careService) {
		this.careService = careService;
	}

	@GetMapping("list")
	public List<CareReview> insert(
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam("n") String careRegNo){
		List<CareReview> list = new ArrayList<>();
		
		if(careRegNo == null || careRegNo.equals("")) {
			return list;
		}
		
		int size = 10;
		list = careService.getReviewList(page, size, careRegNo);
		
		return list;
	}

	@PostMapping("insert")
	public Map<String, Object> insert(String careRegNo, String title, String content, int score){
		Map<String, Object> datas = new HashMap<>();
		int result = 0;
		
		
		if(memberId == 0) {
			datas.put("result", "fail");
			return datas;
		}

		CareReview cr = new CareReview();
		cr.setCareRegNo(careRegNo);
		cr.setMemberId(memberId);
		cr.setTitle(title);
		cr.setContent(content);
		cr.setScore(score);
		
		result = careService.insertReview(cr);
		
		if(result == 0)
			datas.put("result", "fail");
		else
			datas.put("result", "sussess");

		datas.put("careReviewId", cr.getId());
		
		return datas;
	}

	@PostMapping("update")
	public Map<String, Object> update(int id, String title, String content, int score){
		Map<String, Object> datas = new HashMap<>();
		int result = 0;

		if(memberId == 0) {
			datas.put("result", "fail");
			return datas;
		}

		CareReview origin = careService.getReview(id);
		
		origin.setTitle(title);
		origin.setContent(content);
		origin.setScore(score);
		
		result = careService.updateReview(origin);
		
		if(result == 0)
			datas.put("result", "fail");
		else
			datas.put("result", "sussess");
		
		datas.put("careReviewId", origin.getId());
		
		return datas;
	}

	@PostMapping("delete")
	public Map<String, Object> delete(int id){
		Map<String, Object> datas = new HashMap<>();
		int result = 0;
		
		if(memberId == 0) {
			datas.put("result", "fail");
			return datas;
		}
		
		result = careService.deleteReview(id);
		
		if(result == 0)
			datas.put("result", "fail");
		else
			datas.put("result", "sussess");
		
		return datas;
	}
}
