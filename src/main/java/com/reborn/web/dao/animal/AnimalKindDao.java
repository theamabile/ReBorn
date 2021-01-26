package com.reborn.web.dao.animal;

import java.util.List;

import com.reborn.web.entity.animal.AnimalKind;

public interface AnimalKindDao {
	int insert(AnimalKind kind);
	int update(AnimalKind kind);
	int delete(int id);
	
	AnimalKind get(int id);
	List<AnimalKind> getList();
	AnimalKind getKindByCode(String code);
	List<AnimalKind> getKindListByUpKindCode(String upKindCode);
}
