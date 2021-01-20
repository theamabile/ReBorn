package com.reborn.web.entity.data;

import java.util.Date;

public class Catting {
	private int id;
	private int receiverId;
	private int senderId;
	private String content;
	private Date regDate;
	private int roomNo;
	
	
	public Catting() {
		// TODO Auto-generated constructor stub
	}
	
	public Catting(int id, int receiverId, int senderId, String content, Date regDate, int roomNo) {
		this.id = id;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.content = content;
		this.regDate = regDate;
		this.roomNo = roomNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Override
	public String toString() {
		return "Catting [id=" + id + ", receiverId=" + receiverId + ", senderId=" + senderId + ", content=" + content
				+ ", regDate=" + regDate + ", roomNo=" + roomNo + "]";
	}
}
