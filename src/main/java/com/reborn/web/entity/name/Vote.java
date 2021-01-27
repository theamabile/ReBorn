package com.reborn.web.entity.name;

import java.sql.Date;

public class Vote {
	private int id;
	private String animalId;
	private int memberId;
	private int resultId; 
	private Date recruitStartDate;
	private Date recruitEndDate;
	private Date voteStartDate;
	private Date voteEndDate;
	private String state;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getAnimalId() {
		return animalId;
	}

	public void setAnimalId(String animalId) {
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
		return "Vote [id=" + id + ", animalId=" + animalId + ", memberId=" + memberId + ", resultId=" + resultId
				+ ", recruitStartDate=" + recruitStartDate + ", recruitEndDate=" + recruitEndDate + ", voteStartDate="
				+ voteStartDate + ", voteEndDate=" + voteEndDate + ", state=" + state + "]";
	}
	
}
