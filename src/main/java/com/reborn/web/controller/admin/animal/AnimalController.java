package com.reborn.web.controller.admin.animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.reborn.web.entity.animal.AnimalAPIResponseData;
import com.reborn.web.entity.animal.AnimalKind;
import com.reborn.web.entity.animal.AnimalUpKind;
import com.reborn.web.service.animal.AnimalKindService;
import com.reborn.web.service.animal.AnimalService;

/* api를 읽어와서 유기동물 목록을 전시 */
@Controller("adminAnimalController")
@RequestMapping("/admin/animal/")
public class AnimalController {
	
	@Autowired
	AnimalService animalService;

	@Autowired
	AnimalKindService kindService;

	@Value("${animal.kindApiUrl}")
	private String kindUrl;
	
	@Value("${animal.apiKey}")
	private String serviceKey;
		
	
	@RequestMapping("list")
	public String list() {
		
		
		return "admin.animal.detail";
	}
	
	
	// 관리자 페이지에서 목록을 api의 내용으로 업데이트 하겠다는 내용
	@RequestMapping("update")
	public String updateList() {
		
		animalService.updateListFromAPI(2, 100, "", "", null, null, "");
		 
		return "admin.animal.detail";
	}
	
	
	// 관리자 축종/품종 업데이트용 함수 : api로부터 읽어와서 값을 insert/update 함
	@RequestMapping("update/kind")
	public String kind() {

		kindService.updateKindListFromAPI();
		
		return "home.animal.list";
	}
		
	
}
