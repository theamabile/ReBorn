package com.reborn.web.entity.chat;

import java.util.Date;

public class Chatting {
	private int id;
	private int senderId;
	private String content;
	private Date regDate;
	private int roomId;
	
	
	public Chatting() {

	}
	
	public Chatting(int senderId, String content, int roomId) {
		this.senderId = senderId;
		this.content = content;
		this.roomId = roomId;
	}
	
	
	public Chatting(int id, int senderId, String content, Date regDate, int roomId) {
		this.id = id;
		this.senderId = senderId;
		this.content = content;
		this.regDate = regDate;
		this.roomId = roomId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "Chatting [id=" + id + ", senderId=" + senderId + ", content=" + content + ", regDate=" + regDate
				+ ", roomId=" + roomId + "]";
	}
}
