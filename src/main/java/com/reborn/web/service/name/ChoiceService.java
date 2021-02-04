package com.reborn.web.service.name;

import java.util.List;

import com.reborn.web.entity.name.Choice;

public interface ChoiceService {
	int insert(Choice choice);
	int update(Choice choice);
	int delete(long animalId, int memberId);
	
	Choice get(long animalId, int memberId);
	List<Choice> getList();
	
}
