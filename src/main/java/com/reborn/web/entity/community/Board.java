package com.reborn.web.entity.community;

import java.util.Date;

public class Board {
	
	private int id; 
	private String title; 
	private String content; 
	private Date regDate; 
	private String files;
	private int hitCnt;
	private int boardCategoryId;
	
	public Board() {
	
	}

	public Board(int id, String title, String content, Date regDate, String files, int hitCnt, int boardCategoryId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.files = files;
		this.hitCnt = hitCnt;
		this.boardCategoryId = boardCategoryId;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", files="
				+ files + ", hitCnt=" + hitCnt + ", boardCategoryId=" + boardCategoryId + "]";
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

	public int getBoardCategoryId() {
		return boardCategoryId;
	}

	public void setBoardCategoryId(int boardCategoryId) {
		this.boardCategoryId = boardCategoryId;
	}
	
	

		
	
	
}
