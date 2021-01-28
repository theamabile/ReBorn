package com.reborn.web.entity.care;

import java.util.Date;

public class CareReviewReport {

	private int id;
	private int memberId;
	private int careReviewId;
	private Date regDate;
	private String content;
	private int CareReviewReportCategoryId;
	 
	public CareReviewReport() {
		// TODO Auto-generated constructor stub
	}

	public CareReviewReport(int id, int memberId, int careReviewId, Date regDate, String content,
			int careReviewReportCategoryId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.careReviewId = careReviewId;
		this.regDate = regDate;
		this.content = content;
		CareReviewReportCategoryId = careReviewReportCategoryId;
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

	public int getCareReviewId() {
		return careReviewId;
	}

	public void setCareReviewId(int careReviewId) {
		this.careReviewId = careReviewId;
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

	public int getCareReviewReportCategoryId() {
		return CareReviewReportCategoryId;
	}

	public void setCareReviewReportCategoryId(int careReviewReportCategoryId) {
		CareReviewReportCategoryId = careReviewReportCategoryId;
	}

	@Override
	public String toString() {
		return "CareReviewReport [id=" + id + ", memberId=" + memberId + ", careReviewId=" + careReviewId + ", regDate="
				+ regDate + ", content=" + content + ", CareReviewReportCategoryId=" + CareReviewReportCategoryId + "]";
	}
	
}
