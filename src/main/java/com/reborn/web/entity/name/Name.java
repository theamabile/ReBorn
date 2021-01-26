package com.reborn.web.entity.name;

import java.sql.Date;

public class Name {
	private int id;
	private int voteId;
	private int memberId;
	private String name;
	private String reason;
	private Date regDate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Name [id=" + id + ", voteId=" + voteId + ", memberId=" + memberId + ", name=" + name + ", reason="
				+ reason + ", regDate=" + regDate + "]";
	}	
	
}
