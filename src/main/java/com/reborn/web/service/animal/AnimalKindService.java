package com.reborn.web.service.animal;

import java.util.List;

import com.reborn.web.entity.animal.AnimalKind;
import com.reborn.web.entity.animal.AnimalUpKind;

public interface AnimalKindService {
	int insert(AnimalKind kind);
	int update(AnimalKind kind);
	int delete(String cd);
	
	// 축종
	AnimalUpKind getUpKind(String cd);
	AnimalUpKind getUpKind(String field, String query);
	List<AnimalUpKind> getUpKindList();
	
	// 품종
	AnimalKind getKind(String cd);
	AnimalKind getKind(String field, String query);
	List<AnimalKind> getKindList();
	List<AnimalKind> getKindListByUpKindCd(String upKindCd);
	
	// DB에 저장 된 upkind 코드기준으로 kind 목록을 api로부터 가져옴
	int updateKindListFromAPI() ;
	AnimalKind getLastCustomKind();
}
