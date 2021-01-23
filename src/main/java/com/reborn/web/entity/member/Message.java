package com.reborn.web.entity.member;

import java.util.Date;

public class Message {
	
	   private int id;
	   private Date regDate;
	   private String content;
	   private String title;
	   private int receiverId;
	   private int senderId;
	   
	   public Message() {
		// TODO Auto-generated constructor stub
	}
	   
	public Message(int id, Date regDate, String content, String title, int receiverId, int senderId) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.content = content;
		this.title = title;
		this.receiverId = receiverId;
		this.senderId = senderId;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "Message [id=" + id + ", regDate=" + regDate + ", content=" + content + ", title=" + title
				+ ", receiverId=" + receiverId + ", senderId=" + senderId + "]";
	}    
	   
	   
	   
}
