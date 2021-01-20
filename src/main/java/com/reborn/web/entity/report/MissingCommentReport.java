package com.reborn.web.entity.report;

import java.util.Date;

public class MissingCommentReport {
	
	private int id;
	private int memberId;
	private int missingId;
	private String reason;
	private Date regDate;
	
	public MissingCommentReport() {
		// TODO Auto-generated constructor stub
	}

	public MissingCommentReport(int id, int memberId, int missingId, String reason, Date regDate) {
		this.id = id;
		this.memberId = memberId;
		this.missingId = missingId;
		this.reason = reason;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MissingCommentReport [id=" + id + ", memberId=" + memberId + ", missingId=" + missingId + ", reason="
				+ reason + ", regDate=" + regDate + "]";
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
