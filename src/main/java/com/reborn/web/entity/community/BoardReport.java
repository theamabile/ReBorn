package com.reborn.web.entity.community;

import java.util.Date;

public class BoardReport {
	
	private int id;
	private Date regDate;
	private String reason;
	private int memberId;
	private int boardId;
	
	public BoardReport() {
		// TODO Auto-generated constructor stub
	}

	public BoardReport(int id, Date regDate, String reason, int memberId, int boardId) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.reason = reason;
		this.memberId = memberId;
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		return "BoardReport [id=" + id + ", regDate=" + regDate + ", reason=" + reason + "]";
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
	
	
	
}
