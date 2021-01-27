package com.reborn.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.entity.name.NameView;
import com.reborn.web.entity.name.VoteView;
import com.reborn.web.service.name.NameService;
import com.reborn.web.service.name.VoteService;

@RestController("apiNameController")
@RequestMapping("/api/name/")
public class NameController {
	
	@Autowired
	VoteService voteService;
	@Autowired
	NameService nameService;
	
	@RequestMapping("list")
	public Map<String, Object> list(
			@RequestParam(name="p", defaultValue="1") int page,			// 인자에 들어가는 값은 다 스트링으로
			@RequestParam(name="of", defaultValue = "voteStartDate") String orderField,
			@RequestParam(name="oq", defaultValue="DESC") String orderQuery,
			@RequestParam(name="f", required = false) String field,
			@RequestParam(name="q", defaultValue="") String query) {
		
		int size = 2;
		
		List<VoteView> list = voteService.getViewList(page, size, orderField, orderQuery, field, query);
		
		// 해당 투표에서 인기 있기 있는 3가지 후보를 가져옴
		for( VoteView v : list) {
			List<NameView> n = nameService.getViewListByVoteId(v.getId(), 3);
			System.out.println(v.getId()+" rank : "+n.size());
			v.setRankNameList(n);
		}
		int count = voteService.getCount(field, query);
		int pageCount = (int)Math.ceil(count / (float)size);
		
		
		Map<String, Object> dto = new HashMap<>();
		dto.put("list", list);
		//dto.put("pageCount", pageCount);
		dto.put("count", count);
		
		return dto;
	}
	
	
}
