package com.reborn.web.entity.name;

import java.sql.Date;

public class Vote {
	private int id;
	private Date recruitStartDate;
	private Date recruitEndDate;
	private Date voteStartDate;
	private Date voteEndDate;
	private String state;
	private int resultId; 
	private int memberId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public int getResultId() {
		return resultId;
	}
	
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
}
