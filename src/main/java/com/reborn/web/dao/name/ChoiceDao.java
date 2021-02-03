package com.reborn.web.dao.name;

import java.util.List;

import com.reborn.web.entity.name.Choice;

public interface ChoiceDao {
	int insert(Choice choice);
	int update(Choice choice);
	int delete(long animalId, int memberId);
	
	Choice get(long animalId, int memberId);
	List<Choice> getList();
	
	// 뷰는 목록에서 어떤 데이터가 필요한지 분석 후 추가
	
//	List<NoticeView> getViewList();
//	List<NoticeView> getViewList(int offset, int size);
//	List<NoticeView> getViewList(int offset, int size, String field, String query);
//	int getCount(String field, String query);  //검색 결과에 대한 전체 결과 수(페이징은 여기서 필요 없음) 
//	Notice getLast();
//	Notice getPrev(int id);
//	Notice getNext(int id);
}
