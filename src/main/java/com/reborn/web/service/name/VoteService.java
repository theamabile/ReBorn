package com.reborn.web.service.name;

import java.util.Date;
import java.util.List;

import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.Vote;
import com.reborn.web.entity.name.VoteView;

public interface VoteService {
	
	int insert(Vote vote);
	int update(Vote vote);
	int delete(long animalId);
	int deleteAll(long[] animalIds);
	
	Vote get(long animalId);
	List<Vote> getList(int page, int size, String field, String query);
	VoteView getView(long animalId);
	List<VoteView> getViewList(int page, int size, String orderField, String orderQuery, 
			String field, String query, String state, int nameCnt);
	
	List<VoteView> getStartViewList(Date date, String field, String query);
	List<VoteView> getEndViewList(Date date, String field, String query);
	
	int getCount(String field, String query, String state);
	Vote getLast();

}
