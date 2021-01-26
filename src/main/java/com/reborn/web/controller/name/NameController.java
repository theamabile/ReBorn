package com.reborn.web.controller.name;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reborn.web.entity.name.Name;
import com.reborn.web.entity.name.NameView;
import com.reborn.web.entity.name.VoteView;
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
	
	// 이름 투표 목록
	@GetMapping("list")
	public String list(	Model model,
						@RequestParam(name="p", defaultValue="1") int page,			// 인자에 들어가는 값은 다 스트링으로
						@RequestParam(name="of", defaultValue = "voteStartDate") String orderField,
						@RequestParam(name="oq", defaultValue="DESC") String orderQuery,
						@RequestParam(name="f", required = false) String field,
						@RequestParam(name="q", defaultValue="") String query) {
	
		int size = 2;
		
		// name(갖고올때 choice 수 기준으로 order by) + choice 있는지 없는지
		// vote 날짜
		List<VoteView> list = voteService.getViewList(page, size, orderField, orderQuery, field, query);
		
		// 해당 투표에서 인기 있기 있는 3가지 후보를 가져옴
		for( VoteView v : list) {
			List<NameView> n = nameService.getViewListByVoteId(v.getId(), 3);
			System.out.println(v.getId()+" rank : "+n.size());
			v.setRankNameList(n);
		}
		

		int count = voteService.getCount(field, query);
		int pageCount = (int)Math.ceil(count / (float)size);
		System.out.println("count : "+count + " / pageCount : "+pageCount);
		
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("list", list);
		
		return "home.name.list";
	}
	
	// 이름 투표
	@GetMapping("{id}")
	public String choice(@PathVariable(name="id")int id) {
		
		//NameView n = nameService.get(id);
		
		System.out.println("id : "+id);
		return "home.name.detail";
	}
	
	// 이름 짓기
	@GetMapping("{id}/add")
	public String add(@PathVariable(name="id")int id) {
		
		System.out.println("id : "+id);
		
		// redirect:../id
		return "home.name.add";
	}
	
	
}
