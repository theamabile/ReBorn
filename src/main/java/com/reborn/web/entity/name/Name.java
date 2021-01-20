package com.reborn.web.entity.name;

import java.sql.Date;

public class Name {
	private int id;
	private String name;
	private String reason;
	private Date regDate;
	private int voteCnt;
	private int voteId;
	private int memberId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public int getVoteCnt() {
		return voteCnt;
	}
	
	public void setVoteCnt(int voteCnt) {
		this.voteCnt = voteCnt;
	}
	
	public int getVoteId() {
		return voteId;
	}
	
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
}
