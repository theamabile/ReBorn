package com.reborn.web.entity.community;

import java.util.Date;

public class Comment {
	private int id;
	private int memberId;
	private int boardId;
	private String content;
	private Date regDate;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, int memberId, int boardId, String content, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.boardId = boardId;
		this.content = content;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", memberId=" + memberId + ", boardId=" + boardId + ", content=" + content
				+ ", regDate=" + regDate + "]";
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

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
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
	
	
	
}
