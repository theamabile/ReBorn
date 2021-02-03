package com.reborn.web.service.name;

import java.util.List;

import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.Name;
import com.reborn.web.entity.name.NameView;

public interface NameService {
	
	int insert(Name name);
	int update(Name name);
	int delete(long animalId, String name);
	
	Name get(long animalId, String name);
	List<Name> getList(int page, int size, String field, String query);
	
	NameView getView(long animalId, String name);
	List<NameView> getViewList(int page, int size, String field, String query);

	int getCount(String field, String query);
	
	List<NameView> getViewListByAnimalId(long animalId, int size); 		// size만큼 추천수 많은 항목을 가져옴
	NameView getBestName(long animalId);

	//List<NameView> getViewList(int page, int size);
	//int getLastId();
	//Name getPrev(int id);
	//Name getNext(int id);
}
