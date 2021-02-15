package com.reborn.web.entity.name;

import java.util.List;

public class VoteView extends Vote{
	private int nameCnt;
	private int choiceSum;
	private String popfile;
	private List<NameView> rankNameList;
	private boolean choiced;
	private boolean added;
	
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
	
	public String getPopfile() {
		return popfile;
	}

	public void setPopfile(String popfile) {
		this.popfile = popfile;
	}

	public List<NameView> getRankNameList() {
		return rankNameList;
	}

	public void setRankNameList(List<NameView> rankNameList) {
		this.rankNameList = rankNameList;
	}

	public boolean getChoiced() {
		return choiced;
	}

	public void setChoiced(boolean choiced) {
		this.choiced = choiced;
	}

	public boolean getAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}

	@Override
	public String toString() {
		return "VoteView [nameCnt=" + nameCnt + ", choiceSum=" + choiceSum + ", popfile=" + popfile + ", rankNameList="
				+ rankNameList + ", choiced=" + choiced + ", added=" + added + "]";
	}

	
}
