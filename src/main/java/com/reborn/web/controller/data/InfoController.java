package com.reborn.web.controller.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.JsonObject;
import com.reborn.web.entity.data.InfoView;
import com.reborn.web.service.data.DataService;

@Controller
@RequestMapping("/data/")
public class InfoController {
	
	@Autowired
	private DataService service;
	
	//소개페이지
	@RequestMapping("introduce")
	public String introduce() {
		return "home.data.introduce";
	}
	
	
	//리스트페이지
	@RequestMapping("information")
	public String information(
			@RequestParam(name="p", defaultValue="1") int page,
			@RequestParam(name="categroy", defaultValue="1") int categoryId,
			Model model){
		
		int size = 4; //한페이지 출력할 개수
		
		List<InfoView> list = service.getViewList(page, size, categoryId);
		System.out.println(list);
		
		
		Map<Integer, String> imgUrlList = new HashMap<>();
		
		for(InfoView n : list) {
			Matcher match = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>").matcher(n.getContent());			
			if(match.find()) {
				String imgTag = match.group(0);
				imgTag = imgTag.replace("<img src=\"", ""); 
				imgTag = imgTag.replace("\"/>", ""); 		
				//System.out.println("imgTag : "+ imgTag);
				imgUrlList.put(n.getId(), imgTag);
			}
			
			n.setContent(n.getContent().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
		}
		
		
		model.addAttribute("imgUrlList", imgUrlList);
		//System.out.println(" imgUrlList : " + imgUrlList);
		model.addAttribute("list", list);
		
		
		int count = service.getCount(categoryId);
		int pageCount = (int) Math.ceil(count /(float)size); 
		model.addAttribute("pageCount", pageCount);
		return "home.data.information";
	}
	
	
	@RequestMapping("{id}")
	public String informationDetail(@PathVariable("id") int id, Model model) {
		InfoView infoView = service.getView(id);
		
		model.addAttribute("n", infoView);
		return "home.data.detail";
	}
}