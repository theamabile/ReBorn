package com.reborn.web.entity.name;

import java.sql.Date;

public class Vote {
	private long animalId;
	private int memberId;
	private int resultId; 
	private Date recruitStartDate;
	private Date recruitEndDate;
	private Date voteStartDate;
	private Date voteEndDate;
	private String state;			// 자동 업데이트가 되면 필요, 날짜 계산으로 되면 불필요
	
	public Vote() {
		// TODO Auto-generated constructor stub
	}
	
	public Vote(long animalId, int memberId) {
		this.animalId = animalId;
		this.memberId = memberId;
	}

	public long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(long animalId) {
		this.animalId = animalId;
	}
		
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public int getResultId() {
		return resultId;
	}
	
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}	

	public Date getRecruitStartDate() {
		return recruitStartDate;
	}
	
	public void setRecruitStartDate(Date recruitStartDate) {
		this.recruitStartDate = recruitStartDate;
	}
	
	public Date getRecruitEndDate() {
		return recruitEndDate;
	}
	
	public void setRecruitEndDate(Date recruitEndDate) {
		this.recruitEndDate = recruitEndDate;
	}
	
	public Date getVoteStartDate() {
		return voteStartDate;
	}
	
	public void setVoteStartDate(Date voteStartDate) {
		this.voteStartDate = voteStartDate;
	}
	
	public Date getVoteEndDate() {
		return voteEndDate;
	}
	
	public void setVoteEndDate(Date voteEndDate) {
		this.voteEndDate = voteEndDate;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Vote [animalId=" + animalId + ", memberId=" + memberId + ", resultId=" + resultId
				+ ", recruitStartDate=" + recruitStartDate + ", recruitEndDate=" + recruitEndDate + ", voteStartDate="
				+ voteStartDate + ", voteEndDate=" + voteEndDate + ", state=" + state + "]";
	}
	
}
