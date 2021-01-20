package com.reborn.web.entity.data;

import java.util.Date;

public class Info {
	private int id;
	private String title;
	private String content;
	private Date regDate;
	private String files;
	private int hitCnt;
	private int boardCatecoryId;
	private int memberId;
	
	
	public Info() {
		// TODO Auto-generated constructor stub
	}


	public Info(int id, String title, String content, Date regDate, String files, int hitCnt, int boardCatecoryId,
			int memberId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.files = files;
		this.hitCnt = hitCnt;
		this.boardCatecoryId = boardCatecoryId;
		this.memberId = memberId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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


	public String getFiles() {
		return files;
	}


	public void setFiles(String files) {
		this.files = files;
	}


	public int getHitCnt() {
		return hitCnt;
	}


	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
	}


	public int getBoardCatecoryId() {
		return boardCatecoryId;
	}


	public void setBoardCatecoryId(int boardCatecoryId) {
		this.boardCatecoryId = boardCatecoryId;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "Info [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", files="
				+ files + ", hitCnt=" + hitCnt + ", boardCatecoryId=" + boardCatecoryId + ", memberId=" + memberId
				+ "]";
	}	
}
