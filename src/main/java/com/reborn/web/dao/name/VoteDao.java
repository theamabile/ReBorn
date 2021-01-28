package com.reborn.web.dao.name;

import java.util.List;

import com.reborn.web.entity.name.Vote;
import com.reborn.web.entity.name.VoteView;


public interface VoteDao {
	int insert(Vote vote);
	int update(Vote vote);
	int delete(long id);
	int deleteAll(long[] ids);
	
	Vote get(long animalId);
	List<Vote> getList();
	List<Vote> getList(int offset, int size, String field, String query);
	
	VoteView getView(long animalId);
	List<VoteView> getViewList(int offset, int size, String orderField, String orderQuery, String field, String query);
	
	int getCount(String field, String query);
	Vote getLast();
	
}	
