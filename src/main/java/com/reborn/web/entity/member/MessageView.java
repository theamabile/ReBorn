package com.reborn.web.entity.member;

import java.util.Date;

public class MessageView {
	
	   private int id;
	   private Date regDate;
	   private String content;
	   private String title;
	   private int receiverId;
	   private int senderId;
	   private String receiver;
	   private String sender;
	   
	   public MessageView() {
		// TODO Auto-generated constructor stub
	}

	public MessageView(int id, Date regDate, String content, String title, int receiverId, int senderId,
			String receiver, String sender) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.content = content;
		this.title = title;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.receiver = receiver;
		this.sender = sender;
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

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "MessageView [id=" + id + ", regDate=" + regDate + ", content=" + content + ", title=" + title
				+ ", receiverId=" + receiverId + ", senderId=" + senderId + ", receiver=" + receiver + ", sender="
				+ sender + "]";
	}
	
	   
	   
	   
	   
}
