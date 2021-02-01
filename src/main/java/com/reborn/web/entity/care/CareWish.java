package com.reborn.web.entity.care;

import java.util.Date;

public class CareWish {

	private int id;
	private int memberId;
	private String careRegNo;
	private Date regDate;
	
	public CareWish() {
		// TODO Auto-generated constructor stub
	}

	public CareWish(int id, int memberId, String careRegNo, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.careRegNo = careRegNo;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getCareRegNo() {
		return careRegNo;
	}

	public void setCareRegNo(String careRegNo) {
		this.careRegNo = careRegNo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CareWish [id=" + id + ", memberId=" + memberId + ", careRegNo=" + careRegNo + ", regDate=" + regDate
				+ "]";
	}

	
}
