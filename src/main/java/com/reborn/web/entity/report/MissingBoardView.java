package com.reborn.web.entity.report;

import java.util.Date;

public class MissingBoardView {
	private int id; 
	private String title;
	private Date regDate;
	private String location;
	private String files;
	private String nickname;
	private int commentCnt;
	
	public MissingBoardView() {
		// TODO Auto-generated constructor stub
	}

	public MissingBoardView(int id, String title, Date regDate, String location, String files, String nickname,
			int commentCnt) {
		this.id = id;
		this.title = title;
		this.regDate = regDate;
		this.location = location;
		this.files = files;
		this.nickname = nickname;
		this.commentCnt = commentCnt;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

}
