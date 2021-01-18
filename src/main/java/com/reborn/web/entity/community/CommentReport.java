package com.reborn.web.entity.community;

import java.util.Date;

public class CommentReport {
	
	private int id;
	private int memberId;
	private int boardId;
	private String reason;
	private Date regDate;
	
	public CommentReport() {
	}

	public CommentReport(int id, int memberId, int boardId, String reason, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.boardId = boardId;
		this.reason = reason;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CommentReport [id=" + id + ", memberId=" + memberId + ", boardId=" + boardId + ", reason=" + reason
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
