package com.reborn.web.service.animal;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.reborn.web.entity.animal.Animal;


public interface AnimalService {
	int insert(Animal animal);
	int update(Animal animal);
	int delete(long desertionNo);

	
	Animal get(long desertionNo);
	List<Animal> getList();
	List<Animal> getList(int page, int size, String upkind, String kind, Date startDate, Date endDate, String neuter);
	

	int getCount(String upkind, String kind, Date startDate, Date endDate, String neuter);
	
	void updateListFromAPI(int page, int size, String upkind, String kind, Date startDate, Date endDate, String neuter);
//	/Animal getByDesertionNo(long desertionNo);
}
