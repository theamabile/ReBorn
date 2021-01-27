package com.reborn.web.service.name;

import java.util.List;

import com.reborn.web.entity.name.Name;
import com.reborn.web.entity.name.NameView;

public interface NameService {
	
	int insert(Name name);
	int update(Name name);
	int delete(int id);
	int deleteAll(int[] ids);
	
	Name get(int id);
	List<Name> getList(int page, int size, String field, String query);
	
	List<NameView> getViewList(int page, int size, String field, String query);

	int getCount(String field, String query);
	
	List<NameView> getViewListByVoteId(int voteId, int size); 		// size만큼 추천수 많은 항목을 가져옴
	
	//List<NameView> getViewList(int page, int size);
	//int getLastId();
	//Name getPrev(int id);
	//Name getNext(int id);
}
