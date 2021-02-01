package com.reborn.web.entity.report;

import java.util.Date;

public class MissingComment {
	private int id;
	private int memberId;
	private int missingId;
	private Date regDate;
	private String content;
	
	public MissingComment(int memberId, int missingId, String content) {
		this.memberId = memberId;
		this.missingId = missingId;
		this.content = content;
	}

	public MissingComment(int id, int memberId, int missingId, Date regDate, String content) {
		this.id = id;
		this.memberId = memberId;
		this.missingId = missingId;
		this.regDate = regDate;
		this.content = content;
	}

	@Override
	public String toString() {
		return "MissingComment [id=" + id + ", memberId=" + memberId + ", missingId=" + missingId + ", regDate="
				+ regDate + ", content=" + content + "]";
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

	public int getMissingId() {
		return missingId;
	}

	public void setMissingId(int missingId) {
		this.missingId = missingId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
