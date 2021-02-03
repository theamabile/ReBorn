package com.reborn.web.entity.name;

import java.sql.Date;

public class Name {
	private long animalId;
	private int memberId;
	private String name;
	private String reason;
	private Date regDate;
	
	public Name() {
		// TODO Auto-generated constructor stub
	}
		
	public Name(long animalId, int memberId, String name, String reason) {
		this.animalId = animalId;
		this.memberId = memberId;
		this.name = name;
		this.reason = reason;
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

		
}
