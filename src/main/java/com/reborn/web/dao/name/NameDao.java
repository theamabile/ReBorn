package com.reborn.web.dao.name;

import java.util.List;

import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.Name;
import com.reborn.web.entity.name.NameView;

public interface NameDao {
	int insert(Name name);
	int update(Name name);
	int delete(int id);	
	int deleteAll(int[] ids);
	
	Name get(int id);	
	List<Name> getList();
	List<Name> getList(int offset, int size, String field, String query);
	List<NameView> getViewList(int offset, int size, String field, String query);
	List<NameView> getViewListByVoteId(int voteId, int size);
	
	int getCount(String field, String query);

}
