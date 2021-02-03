package com.reborn.web.dao.name;

import java.util.List;

import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.Name;
import com.reborn.web.entity.name.NameView;

public interface NameDao {
	int insert(Name name);
	int update(Name name);
	int delete(long animalId, String name);
	
	Name get(long animalId, String name);	
	List<Name> getList();
	List<Name> getList(int offset, int size, String field, String query);
	
	NameView getView(long animalId, String name);
	List<NameView> getViewList(int offset, int size, String field, String query);
	List<NameView> getViewListByAnimalId(long animalId, int size);
	
	int getCount(String field, String query);
	NameView getBestName(long animalId);	// 해당 동물의 이름짓기 중 최종으로 뽑힌 가장 인기 많은 이름

}
