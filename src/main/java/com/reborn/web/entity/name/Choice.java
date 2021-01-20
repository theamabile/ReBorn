package com.reborn.web.entity.name;

import java.sql.Date;

public class Choice {
	private int id;
	private Date regDate;
	private int memberId;
	private int nameId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public int getNameId() {
		return nameId;
	}
	
	public void setNameId(int nameId) {
		this.nameId = nameId;
	}
	
}
