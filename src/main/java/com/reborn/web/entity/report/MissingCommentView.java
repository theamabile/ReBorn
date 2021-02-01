package com.reborn.web.entity.report;

import java.util.Date;

public class MissingCommentView {
	private int id;
	private int missingId;
	private Date regDate;
	private String content;
	private int memberId;
	private String nickname;
	
	
	public MissingCommentView() {
		// TODO Auto-generated constructor stub
	}
	
	public MissingCommentView(int id, int missingId, Date regDate, String content, int memberId, String nickname) {
		this.id = id;
		this.missingId = missingId;
		this.regDate = regDate;
		this.content = content;
		this.memberId = memberId;
		this.nickname = nickname;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMissingId() {
		return missingId;
	}


	public void setMissingId(int missingId) {
		this.missingId = missingId;
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


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
