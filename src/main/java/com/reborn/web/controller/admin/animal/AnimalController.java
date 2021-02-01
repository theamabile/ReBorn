package com.reborn.web.controller.admin.animal;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reborn.web.entity.animal.Animal;
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
		
		List<Animal> list = animalService.getListByCareRegNo("311300201300001");
		for(Animal a : list ) {
			System.out.println(a.getDesertionNo()+" - careNo : "+a.getCareRegNo());
		}
		
		return "admin.animal.list";
	}
	
	// 관리자 페이지에서 목록을 api의 내용으로 업데이트 하겠다는 내용
	@RequestMapping("update")
	public String updateList() {

		animalService.updateListFromAPI(1, 3000, "", "", null, null, "");

		return "admin.animal.detail";
	}


	// 관리자 축종/품종 업데이트용 함수 : api로부터 읽어와서 값을 insert/update 함
	@RequestMapping("update/kind")
	public String kind() {

		kindService.updateKindListFromAPI();

		return "home.animal.list";
	}

}
