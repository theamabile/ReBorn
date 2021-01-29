package com.reborn.web.entity.member;

public class BlackList {

	   private int id;
	   private String type;
	   private int memberId;
	
	   
	   public BlackList() {
		// TODO Auto-generated constructor stub
	}


	public BlackList(int id, String type, int memberId) {
		super();
		this.id = id;
		this.type = type;
		this.memberId = memberId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "BlackList [id=" + id + ", type=" + type + ", memberId=" + memberId + "]";
	}
	   
	   
}
