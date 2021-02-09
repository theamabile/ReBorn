package com.reborn.web.entity.data;

import java.util.Date;

public class Info {
	private int id;
	private String title;
	private String content;
	private Date regDate;
	private int hitCnt;
	private int infoCategoryId;
	private int memberId;
	
	
	public Info() {
		// TODO Auto-generated constructor stub
	}
	

	public Info(int id, String title, String content, Date regDate, int hitCnt, int infoCategoryId,
			int memberId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hitCnt = hitCnt;
		this.infoCategoryId = infoCategoryId;
		this.memberId = memberId;
	}


	public Info(String title, String content, int infoCategoryId, int memberId) {
		this.title = title;
		this.content = content;
		this.infoCategoryId = infoCategoryId;
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


	public int getHitCnt() {
		return hitCnt;
	}


	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
	}


	public int infoCategoryId() {
		return infoCategoryId;
	}


	public void setBoardCatecoryId(int infoCategoryId) {
		this.infoCategoryId = infoCategoryId;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "Info [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", hitCnt="
				+ hitCnt + ", boardCatecoryId=" + infoCategoryId + ", memberId=" + memberId + "]";
	}


	
}
