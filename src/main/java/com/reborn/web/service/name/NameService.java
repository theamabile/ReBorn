package com.reborn.web.service.name;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.Name;
import com.reborn.web.entity.name.NameView;
import com.reborn.web.entity.name.VoteView;

public interface NameService {
	
	int insert(Name name);
	int update(Name name);
	int delete(long animalId, String name);
	
	Name get(long animalId, String name);
	List<Name> getList(int page, int size, String field, String query);
	
	NameView getView(long animalId, String name);
	List<NameView> getViewList(int page, int size, String orderField, String orderQuery, String field, String query);

	int getCount(String field, String query);
	NameView getBestName(long animalId);

	void getAddedListByMemberId(int memberId, List<VoteView> list);		// 인자로 넘겨받은 리스트 중에서 사용자가 이름짓기에 참여한 것이 있는지 판단하는 함수
}
