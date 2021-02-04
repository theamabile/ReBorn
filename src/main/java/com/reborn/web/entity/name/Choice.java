package com.reborn.web.entity.name;

import java.sql.Date;

public class Choice {
	private long animalId;
	private int memberId;
	private String name;
	private Date regDate;
	
	
	public Choice() {
		// TODO Auto-generated constructor stub
	}

	public Choice(long animalId, int memberId, String name) {
		super();
		this.animalId = animalId;
		this.memberId = memberId;
		this.name = name;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}	
}
