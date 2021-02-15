package com.reborn.web.controller.data.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reborn.web.entity.data.InfoView;
import com.reborn.web.service.data.DataService;

@RestController("apiInfoController")
@RequestMapping("/api/data/")
public class InfoController {
	
	@Autowired
	private DataService service;
	
	//리스트페이지
	@RequestMapping("information")
	public Map<String, Object> information(
			@RequestParam(name="p", defaultValue="1") int page,
			@RequestParam(name="categroy", defaultValue="0") int categoryId,
			Model model){
		int size = 3; //한페이지 출력할 개수
		
		List<InfoView> list = service.getViewList(page, size, categoryId);
		//System.out.println(list);
		
		
		Map<Integer, String> imgUrlList = new HashMap<>();
		
		for(InfoView n : list) {
			Matcher match = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>").matcher(n.getContent());			
			if(match.find()) {
				String imgTag = match.group(0);
				imgTag = imgTag.replace("<img src=\"", ""); 
				imgTag = imgTag.replace("\">", ""); 	
				imgTag = imgTag.replace("\\", "/");		
				//System.out.println("imgTag : "+ imgTag);
				imgUrlList.put(n.getId(), imgTag);
			}
			
			n.setContent(n.getContent().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
		}
		
		
		
		//model.addAttribute("imgUrlList", imgUrlList);
		//System.out.println(" imgUrlList : " + imgUrlList);
		//model.addAttribute("list", list);
		
		
		int count = service.getCount(categoryId);
		int pageCount = (int) Math.ceil(count /(float)size); 
		model.addAttribute("pageCount", pageCount);
		
		Map<String, Object> dto = new HashMap<>();
		dto.put("imgUrlList", imgUrlList);
		dto.put("list", list);
		dto.put("pageCount", pageCount);
		return dto;
	}
	
}
