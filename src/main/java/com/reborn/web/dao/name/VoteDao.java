package com.reborn.web.dao.name;

import java.util.List;

import com.reborn.web.entity.name.Vote;


public interface VoteDao {
	int insert(Vote name);
	int update(Vote name);
	int delete(int id);
	
	Vote get(int id);
	List<Vote> getList();

	List<Vote> getList(int offset, int size, String field, String query);
	List<Vote> getList(int startIndex);
}	
