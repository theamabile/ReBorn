package com.reborn.web.service.animal;

import java.util.List;

import com.reborn.web.entity.animal.AnimalKind;
import com.reborn.web.entity.animal.AnimalUpKind;

public interface AnimalKindService {
	int insert(AnimalKind kind);
	int update(AnimalKind kind);
	int delete(int id);
	
	AnimalUpKind getUpKind(int id);
	List<AnimalUpKind> getUpKindList();
	AnimalUpKind getUpKindByCode(String code);
	

	AnimalKind getKind(int id);
	List<AnimalKind> getKindList();
	AnimalKind getKindByCode(String code);
	List<AnimalKind> getKindListByUpKindCode(String upKindCode);
	
	// DB에 저장 된 upkind 코드기준으로 kind 목록을 api로부터 가져옴
	int updateKindListFromAPI() ;
}
