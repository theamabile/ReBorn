package com.reborn.web.controller.name;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

/* 이름 짓기 및 이름 선택(투표) */

@Controller
@RequestMapping("/name/")
public class NameController {

	@Autowired
	private VoteService voteService;
	@Autowired
	private NameService nameService;
	@Autowired
	private ChoiceService choiceService;
	@Autowired
	private AnimalService animalService;
	@Autowired
	private MemberService memberService;
	
	// 이름 투표 목록
	@GetMapping("list")
	public String list(	Model model,
						@RequestParam(name="p", defaultValue="1") int page,			// 인자에 들어가는 값은 다 스트링으로
						@RequestParam(name="of", defaultValue = "voteStartDate") String orderField,
						@RequestParam(name="oq", defaultValue="DESC") String orderQuery,
						@RequestParam(name="f", required = false) String field,
						@RequestParam(name="q", defaultValue="") String query,
						@RequestParam(name="s", defaultValue="START") String state) {
	
		int size = 5;
		
		// name(갖고올때 choice 수 기준으로 order by) + choice 있는지 없는지
		// vote 날짜
		List<VoteView> list = voteService.getViewList(page, size, orderField, orderQuery, field, query, state, 0);
		
		// 해당 투표에서 인기 있기 있는 3가지 후보를 가져옴
		for( VoteView v : list) {
			List<NameView> n = nameService.getViewList(1, 3, "choiceCnt", "DESC", "animalId", String.valueOf(v.getAnimalId()));
			v.setRankNameList(n);
		}

		int count = voteService.getCount(field, query, state);
		int pageCount = (int)Math.ceil(count / (float)size);
		if(pageCount < 1) 
			pageCount = 1;
		
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("list", list);
		
		return "home.name.list";
	}
	
	
	// 이름 투표
	@GetMapping("{desertionNo}")
	public String choice(@PathVariable(name="desertionNo")long animalId, Model model, HttpServletRequest request) {
		// 이름 짓기가 끝났을때 -> 이동X
		// 이름 투표 중일 때 -> choice;
		// 이름 투표중이 아닐 때 => add
		
		Animal a = animalService.get(animalId);
		VoteView v = voteService.getView(animalId);

		int choiceSum = 0;
		List<NameView> nameList = new ArrayList<NameView>();
		if(v != null) {	// 후보를 받았던 적이 있음(이미 vote가 있음)
			nameList = nameService.getViewList(1, 9999, "regDate", "DESC", "animalId", String.valueOf(animalId));
			
			for(NameView n : nameList) {	 		// 투표수 합계를 구함
				choiceSum += n.getChoiceCnt();
			}
		}		
		
		HttpSession session = request.getSession();
		int memberId = (int)session.getAttribute("id");
		Choice choice = choiceService.get(animalId, memberId);
		
		model.addAttribute("nameList", nameList);
		model.addAttribute("animal", a);
		model.addAttribute("vote", v);
		model.addAttribute("choice", choice);
		model.addAttribute("choiceSum", choiceSum);
		
		return "home.name.detail";
	}
	

	@PostMapping("{desertionNo}")
	public String choice(@PathVariable(name="desertionNo") long animalId,
						@RequestParam(name="name") String name,
						HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int memberId = (int)session.getAttribute("id");
		
		Choice choice = new Choice(animalId, memberId, name);
		choiceService.insert(choice);
		
		return "redirect:"+animalId;
	}
	
	
	// 이름 짓기
	@GetMapping("{desertionNo}/add")
	public String add(@PathVariable(name="desertionNo")long animalId, Model model) {
		
		System.out.println("No Api get [add] ============ " +animalId);
		VoteView v = voteService.getView(animalId);
		
		List<NameView> nameList = new ArrayList<NameView>();
		if(v != null) {	// 후보를 받았던 적이 있음(이미 vote가 있음)
			nameList = nameService.getViewList(1, 9999, "regDate", "DESC", "animalId", String.valueOf(animalId));
		} else {
			System.out.println("v is null");
		}


		System.out.println("nameList size : "+nameList.size());
		
		Animal a = animalService.get(animalId);

		model.addAttribute("nameList", nameList);
		model.addAttribute("animal", a);
		model.addAttribute("vote", v);	

		return "home.name.add";
	}
	

	@GetMapping("{desertionNo}/revote")
	public String add(@PathVariable(name="desertionNo")long animalId, HttpServletRequest request) {

		HttpSession session = request.getSession();
		int memberId = (int)session.getAttribute("id");
		String loginId = (String)session.getAttribute("loginId");		
		int point = -10;
				
		Choice choice = choiceService.get(animalId, memberId);
		if(choice != null) {
			choiceService.delete(animalId, memberId);
			memberService.pointUp(loginId, point);		// 포인트 감소
		}
		
		return "redirect:../"+animalId;
	}
	

	@GetMapping("recruit")
	public String recruit(	Model model,
						@RequestParam(name="p", defaultValue="1") int page,			// 인자에 들어가는 값은 다 스트링으로
						@RequestParam(name="of", defaultValue = "voteStartDate") String orderField,
						@RequestParam(name="oq", defaultValue="DESC") String orderQuery,
						@RequestParam(name="f", required = false) String field,
						@RequestParam(name="q", defaultValue="") String query,
						@RequestParam(name="s", defaultValue="NONE") String state) {
	
		int size = 5;
		
		// state가 NONE(투표 생성 됨)이고 이름이 1개 이상인 아이들을 갖고옴
		List<VoteView> list = voteService.getViewList(page, size, orderField, orderQuery, field, query, state, 0);
		
		// 해당 투표에서 인기 있기 있는 3가지 후보를 가져옴
		for( VoteView v : list) {
			List<NameView> n = nameService.getViewList(1, 3, "choiceCnt", "DESC", "animalId", String.valueOf(v.getAnimalId()));
			v.setRankNameList(n);
		}

		int count = voteService.getCount(field, query, state);
		int pageCount = (int)Math.ceil(count / (float)size);
		if(pageCount < 1) 
			pageCount = 1;
		
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("list", list);
		
		return "home.name.recruit";
	}
	
}
