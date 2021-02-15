package com.reborn.web.service.name;

import java.util.List;

import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.VoteView;

public interface ChoiceService {
	int insert(Choice choice);
	int update(Choice choice);
	int delete(long animalId, int memberId);
	
	Choice get(long animalId, int memberId);
	List<Choice> getList();
	
	void getChoicedListByMemberId(int memberId, List<VoteView> list);		// 인자로 넘겨받은 리스트 중에서 사용자가 투표에 참여한 것이 있는지 판단하는 함수
}
