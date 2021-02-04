package com.reborn.web.entity.data;

import java.util.Date;

public class InfoView {
	private int id;
	private String title;
	private String content;
	private Date regDate;
	private int hitCnt;
	private String cateName;

	 public InfoView() {
		 
	}

	public InfoView(int id, String title, String content, Date regDate, int hitCnt, String cateName) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hitCnt = hitCnt;
		this.cateName = cateName;
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


	public int getHitCnt() {
		return hitCnt;
	}

	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String toString() {
		return "InfoView [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", hitCnt="
				+ hitCnt + ", cateName=" + cateName + "]";
	}

	
}




