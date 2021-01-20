package com.reborn.web.dao.name;

import java.util.List;

import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.Name;

public interface NameDao {
	int insert(Name name);
	int update(Name name);
	int delete(int id);
	
	Name get(int id);
	List<Name> getList();

	List<Name> getList(int offset, int size, String field, String query);
	List<Name> getList(int startIndex);
}
