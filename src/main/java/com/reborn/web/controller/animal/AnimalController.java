package com.reborn.web.controller.animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.reborn.web.entity.animal.Animal;
import com.reborn.web.entity.animal.AnimalKind;
import com.reborn.web.entity.animal.AnimalUpKind;
import com.reborn.web.entity.name.Vote;
import com.reborn.web.service.animal.AnimalKindService;
import com.reborn.web.service.animal.AnimalService;
import com.reborn.web.service.name.VoteService;

/* api를 읽어와서 유기동물 목록을 전시 */
@Controller
@RequestMapping("/animal/")
public class AnimalController {
	
	@Autowired
	AnimalService animalService;

	@Autowired
	AnimalKindService kindService;
	
	@Autowired
	VoteService voteService;


	@Value("${animal.kindApiUrl}")
	private String kindUrl;
	
	@Value("${animal.apiKey}")
	private String serviceKey;
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	// @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime 

	
	@RequestMapping("list")
	public String list(
			@RequestParam(name="p", defaultValue="1") 	 int page,
			@RequestParam(name="upkind", required=false) String upkind,		//축종 코드
			@RequestParam(name="kind", required=false) 	 String kind,		//품종 코드
			@RequestParam(name="bgnde", required=false)  String bgnde, 		//유기 시작 날짜
			@RequestParam(name="endde", required=false)	 String endde, 		//유기 종료 날짜
			//@RequestParam(name="endde", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endde,	//유기 종료 날짜
			@RequestParam(name="neuter", required=false) String neuter
			, Model model) {

		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		if( bgnde != null)
		try {
			startDate = formatter.parse(bgnde);
		} catch (ParseException e) {
         // TODO Auto-generated catch block
			e.printStackTrace();
		}  
	      
		
//		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");		
//		
//		Date startDate = null;
//		Date endDate = null;
//		if(bgnde != null && !bgnde.equals("")) {
//			try {
//				startDate = new Date(inputFormat.parse(bgnde).getTime());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		if(endde != null && !endde.equals("")) {
//			try {
//				endDate = new Date(inputFormat.parse(endde).getTime());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		System.out.println("endDate : "+endDate+" / startDate : "+startDate);
		System.out.println("startDate : "+startDate);
		
		int size = 9;		
		List<Animal> list = animalService.getList(page, size, upkind, kind, startDate, endDate, neuter); 
		
		int count =	animalService.getCount(upkind, kind, (java.sql.Date)startDate, (java.sql.Date)endDate, neuter);
				
		int pageCount = (int)Math.ceil(count / (float)size);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("list", list);
			
		return "home.animal.list";
	}
	
	
	@RequestMapping("{desertionNo}")
	public String detail(@PathVariable(name="desertionNo") long no, Model model) {
		
		System.out.println("desertionNo : "+no);
		
		Animal a = animalService.get(no);
		Vote v = voteService.get(no);
		
		String nameUrl = "add";	
		if(v == null) {		// 이름 짓기가 진행되지 않음
			nameUrl = "add";			
		} else {	// 이름 짓기가 진행중이거나 완료됨
				
			// 이름 짓기가 진행되지 않거나, 이름 후보를 받는 중임 -> add
			// 투표가 진행중이면 -> name/{id}/detail
			// 투표가 끝났으면 -> 이동X(버튼 안띄움)
			
		}
		
		
		model.addAttribute("animal", a);		
		
		return "home.animal.detail";
	}
	
	
}
