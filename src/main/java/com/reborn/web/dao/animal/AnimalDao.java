package com.reborn.web.dao.animal;

import java.util.Date;
import java.util.List;

import com.reborn.web.entity.animal.Animal;

public interface AnimalDao {
	
	int insert(Animal kind);
	int update(Animal kind);
	int delete(long desertionNo);
	
	Animal get(long desertionNo);
	List<Animal> getList();
	List<Animal> getList(int offset, int size, String upKindCd, String kindCd, Date startDate, Date endDate, String neuter);

	int getCount(String upkind, String kind, Date startDate, Date endDate, String neuter);
	Animal getByDesertionNo(long desertionNo);
	
}
