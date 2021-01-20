package com.reborn.web.entity.care;

import java.sql.Date;

public class CareEvaluation {

	private int id;
	private String careRegNo;
	private int memberId;
	private String content;
	private String score;
	private Date regDate;
	private String title;
	
	public CareEvaluation() {
		// TODO Auto-generated constructor stub
	}

	public CareEvaluation(int id, String careRegNo, int memberId, String content, String score, Date regDate,
			String title) {
		super();
		this.id = id;
		this.careRegNo = careRegNo;
		this.memberId = memberId;
		this.content = content;
		this.score = score;
		this.regDate = regDate;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCareRegNo() {
		return careRegNo;
	}

	public void setCareRegNo(String careRegNo) {
		this.careRegNo = careRegNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "CareEvaluation [id=" + id + ", careRegNo=" + careRegNo + ", memberId=" + memberId + ", content="
				+ content + ", score=" + score + ", regDate=" + regDate + ", title=" + title + "]";
	}

}
