package com.reborn.web.dao.name;

import java.util.List;

import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.VoteView;

public interface ChoiceDao {
	int insert(Choice choice);
	int update(Choice choice);
	int delete(long animalId, int memberId);
	
	Choice get(long animalId, int memberId);
	List<Choice> getList();
	List<Long> getChoicedIdsByMemberId(int memberId, List<VoteView> list);
}
