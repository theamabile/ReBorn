package com.reborn.web.service.animal;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.reborn.web.entity.animal.Animal;
import com.reborn.web.entity.animal.AnimalAPIResponseData;

public interface AnimalService {
	int insert(Animal animal);
	int update(Animal animal);
	int delete(long desertionNo);

	int getCount();
	
	Animal get(long desertionNo);
	List<Animal> getList();
	List<Animal> getList(int page, int size, String upkind, String kind, Date startDate, Date endDate, String neuter);
	
	// API를 조회하여 List<Animal>와 count를 담은 AnimalAPI 객체를 리턴, 
	// 리스트 데이터를 json화 시키는건 Controller에서 쓰임새에 따라 알아서 할거임
	AnimalAPIResponseData getListFromAPI(int page, int size, String upkind, String kind, Date startDate, Date endDate, String neuter);
	void updateListFromAPI(int page, int size, String upkind, String kind, Date startDate, Date endDate, String neuter);
	Animal getByDesertionNo(long desertionNo);
}
