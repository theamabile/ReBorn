package com.reborn.web.service.name;

import java.util.List;

import com.reborn.web.entity.name.Vote;
import com.reborn.web.entity.name.VoteView;

public interface VoteService {
	
	int insert(Vote vote);
	int update(Vote vote);
	int delete(int id);
	int deleteAll(int[] ids);
	
	Vote get(int id);
	List<Vote> getList(int page, int size, String field, String query);
	List<VoteView> getViewList(int page, int size, String orderField, String orderQuery, String field, String query);

	int getCount(String field, String query);
}
