package com.reborn.web.controller.api.name;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.reborn.web.entity.animal.Animal;
import com.reborn.web.entity.member.Member;
import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.Name;
import com.reborn.web.entity.name.NameView;
import com.reborn.web.entity.name.Vote;
import com.reborn.web.entity.name.VoteView;
import com.reborn.web.service.animal.AnimalService;
import com.reborn.web.service.member.MemberService;
import com.reborn.web.service.name.ChoiceService;
import com.reborn.web.service.name.NameService;
import com.reborn.web.service.name.VoteService;

@RestController("apiNameController")
@RequestMapping("/api/name/")
public class NameController {
	
	@Autowired
	private VoteService voteService;
	@Autowired
	private NameService nameService;
	@Autowired
	private ChoiceService choiceService;
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("list")
	public Map<String, Object> list(
			@RequestParam(name="p", defaultValue="1") int page,			// 인자에 들어가는 값은 다 스트링으로
			@RequestParam(name="of", defaultValue = "voteStartDate") String orderField,
			@RequestParam(name="oq", defaultValue="DESC") String orderQuery,
			@RequestParam(name="f", required = false) String field,
			@RequestParam(name="q", defaultValue="") String query,
			@RequestParam(name="s", defaultValue="START") String state,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		int memberId = (int)session.getAttribute("id");
		
		int size = 5;
		List<VoteView> list = voteService.getViewList(page, size, orderField, orderQuery, field, query, state, 0);
		
		// 해당 투표에서 인기 있기 있는 3가지 후보를 가져옴
		for( VoteView v : list) {
			List<NameView> n = nameService.getViewList(1, 3, "choiceCnt", "DESC", "animalId", String.valueOf(v.getAnimalId()));
			v.setRankNameList(n);
		}
		
		// 회원의 투표 참여 여부를 받아옴
		choiceService.getChoicedListByMemberId(memberId, list);
		
		
		int count = voteService.getCount(field, query, state);
		int pageCount = (int)Math.ceil(count / (float)size);
		if(pageCount < 1) 
			pageCount = 1;
		
		
		Map<String, Object> dto = new HashMap<>();
		dto.put("list", list);
		dto.put("pageCount", pageCount);
		
		return dto;
	}
	
	
	@PostMapping("{desertionNo}")
	public Map<String, Object> choice(@PathVariable(name="desertionNo") long animalId,
						@RequestParam(name="name") String name,
						HttpServletRequest request) {		//@RequestBody String data,	// 제이슨 형태로 값 넘겨 받기
		
		HttpSession session = request.getSession();
		int memberId = (int)session.getAttribute("id");
		String loginId = (String)session.getAttribute("loginId");
		
		Choice choice = new Choice(animalId, memberId, name);
		int result = choiceService.insert(choice);
		
		int point = 10;
		
		boolean success = false;
		if(result > 0) {
			success = true;
			memberService.pointUp(loginId, point);
			memberService.nameCountUp(loginId);
		}
		
		Member member = memberService.get(loginId);
				
		Map<String, Object> dto = new HashMap<String, Object>();
		dto.put("success", success);
		dto.put("newPoint", point);
		dto.put("point", member.getPoint());
		return dto;
	}	
	
	
	// 이름 짓기
//	@GetMapping("{desertionNo}/add")
//	public String add(@PathVariable(name="desertionNo")long animalId, Model model) {
//		VoteView v = voteService.getView(animalId);
//		
//		
//		List<NameView> nameList = new ArrayList<NameView>();
//		if(v != null) {	// 후보를 받았던 적이 있음(이미 vote가 있음)
//			nameList = nameService.getViewList(1, 99999, "regDate", "DESC", "animalId", String.valueOf(animalId));
//			System.out.println("v : "+v.getNameCnt());	
//			System.out.println("nameList : "+nameList.size());	
//			System.out.println("animalId : "+animalId);	
//		}		
//
//		
//		Animal a = animalService.get(animalId);
//
//		model.addAttribute("nameList", nameList);
//		model.addAttribute("animal", a);
//		model.addAttribute("vote", v);	
//
//		return "home.name.add";
//	}
	
	@PostMapping("{desertionNo}/add")
	public Map<String, Object> add(@PathVariable(name="desertionNo")long animalId,
					  @RequestParam(name="name") String name,
					  @RequestParam(name="reason") String reason,
					  HttpServletRequest request) {

		HttpSession session = request.getSession();
		int memberId = (int)session.getAttribute("id");

		Vote v = voteService.get(animalId);
		if(v == null) {	// 이름을 처음 받음
			// vote 추가
			Vote newVote = new Vote(animalId, memberId);
			int result = voteService.insert(newVote);		// 보트 추가되었으면(나중에 트랜잭션으로 처리)
			if(result == 1) {
				v = voteService.get(animalId);
			}
			
		}	

		boolean success = false;
		Map<String, Object> dto = new HashMap<String, Object>();
		
		Name n = new Name(v.getAnimalId(), memberId, name, reason);
		int result = 0;
		result = nameService.insert(n);	
		
		String loginId = (String)session.getAttribute("loginId");
		Member member = memberService.get(loginId);
		int point = 10;
		
		if(result > 0) {
			success = true;
			memberService.pointUp(loginId, point);
			memberService.nameCountUp(loginId);
		}
		
		dto.put("newPoint", point);
		dto.put("point", member.getPoint());
		
		
		dto.put("success", success);
		
		return dto;
	}
	
		
	@GetMapping("recruit")
	public Map<String, Object> recruit(	Model model,
						@RequestParam(name="p", defaultValue="1") int page,			// 인자에 들어가는 값은 다 스트링으로
						@RequestParam(name="of", defaultValue = "recruitStartDate") String orderField,
						@RequestParam(name="oq", defaultValue="DESC") String orderQuery,
						@RequestParam(name="f", required = false) String field,
						@RequestParam(name="q", defaultValue="") String query,
						@RequestParam(name="s", defaultValue="NONE") String state,
						HttpServletRequest request) {

		HttpSession session = request.getSession();
		int memberId = (int)session.getAttribute("id");
		
		int size = 5;
		
		// state가 NONE(투표 생성 됨)이고 이름이 1개 이상인 아이들을 갖고옴
		List<VoteView> list = voteService.getViewList(page, size, orderField, orderQuery, field, query, state, 0);
		
		for( VoteView v : list) {
			List<NameView> n = nameService.getViewList(1, 3, "choiceCnt", "DESC", "animalId", String.valueOf(v.getAnimalId()));
			v.setRankNameList(n);
		}

		// 회원의 이름 짓기 여부를 받아옴
		nameService.getAddedListByMemberId(memberId, list);
		
		
		int count = voteService.getCount(field, query, state);
		int pageCount = (int)Math.ceil(count / (float)size);
		if(pageCount < 1) 
			pageCount = 1;
		
		
		Map<String, Object> dto = new HashMap<>();
		dto.put("list", list);
		dto.put("pageCount", pageCount);
		
		return dto;
	}
	
	
	
}
