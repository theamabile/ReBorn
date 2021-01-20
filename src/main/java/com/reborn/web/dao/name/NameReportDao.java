package com.reborn.web.dao.name;

import java.util.List;

import com.reborn.web.entity.name.NameReport;

public interface NameReportDao {
	int insert(NameReport name);
	int update(NameReport name);
	int delete(int id);
	
	NameReport get(int id);
	List<NameReport> getList();

	List<NameReport> getList(int offset, int size, String field, String query);
	List<NameReport> getList(int startIndex);
}
