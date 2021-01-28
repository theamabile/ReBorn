package com.reborn.web.entity.name;

import java.util.List;

public class VoteView extends Vote{
	private int nameCnt;
	private int choiceSum;
	private List<NameView> rankNameList;
	
	public int getNameCnt() {
		return nameCnt;
	}
	
	public void setNameCnt(int nameCnt) {
		this.nameCnt = nameCnt;
	}
	
	public int getChoiceSum() {
		return choiceSum;
	}
	
	public void setChoiceSum(int choiceSum) {
		this.choiceSum = choiceSum;
	}

	public List<NameView> getRankNameList() {
		return rankNameList;
	}

	public void setRankNameList(List<NameView> rankNameList) {
		this.rankNameList = rankNameList;
	}

	@Override
	public String toString() {
		return "VoteView [nameCnt=" + nameCnt + ", choiceSum=" + choiceSum + "]";
	}
	
}
