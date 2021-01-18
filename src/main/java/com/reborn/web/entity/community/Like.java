package com.reborn.web.entity.community;

public class Like {
	private int id;
	private int memberId;
	private int boardId;
	
	public Like() {
		// TODO Auto-generated constructor stub
	}

	public Like(int id, int memberId, int boardId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", memberId=" + memberId + ", boardId=" + boardId + "]";
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
	
	
	
}
