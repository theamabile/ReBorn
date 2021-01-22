package com.reborn.web.entity.member;

import java.util.Date;

public class MessageReport {

	   private int id;
	   private String content;
	   private String title;
	   private Date regDate;
	   private int messageId;
	   private int memberId;
	   

	   public MessageReport() {
		// TODO Auto-generated constructor stub
	}


	public MessageReport(int id, String content, String title, Date regDate, int messageId, int memberId) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
		this.regDate = regDate;
		this.messageId = messageId;
		this.memberId = memberId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getMessageId() {
		return messageId;
	}


	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "MessageReport [id=" + id + ", content=" + content + ", title=" + title + ", regDate=" + regDate
				+ ", messageId=" + messageId + ", memberId=" + memberId + "]";
	}
	   
	   
	   
}
