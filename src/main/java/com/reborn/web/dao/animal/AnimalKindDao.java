package com.reborn.web.dao.animal;

import java.util.List;

import com.reborn.web.entity.animal.AnimalKind;

public interface AnimalKindDao {
	int insert(AnimalKind kind);
	int update(AnimalKind kind);
	int delete(String cd);
	
	// 조건으로 아이템 하나를 경우가 많아 field와 query를 만들어놓음
	AnimalKind get(String field, String query);		
	List<AnimalKind> getList();
	List<AnimalKind> getKindListByUpKindCd(String upKindCd);
	AnimalKind getLastCustomKind();
}
