package com.reborn.web.dao.animal;

import java.util.List;

import com.reborn.web.entity.animal.AnimalUpKind;

public interface AnimalUpKindDao {
	int insert(AnimalUpKind upkind);
	int update(AnimalUpKind upkind);
	int delete(int id);
	
	AnimalUpKind get(int id);
	List<AnimalUpKind> getList();
	AnimalUpKind getUpKindByCode(String code);
}
