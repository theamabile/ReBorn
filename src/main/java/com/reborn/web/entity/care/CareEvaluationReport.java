package com.reborn.web.entity.care;

import java.sql.Date;

public class CareEvaluationReport {

	private int id;
	private int memberId;
	private int careEvaluationId;
	private Date regDate;
	private String content;
	private int CareEvaluationReportCategoryId;
	 
	public CareEvaluationReport() {
		// TODO Auto-generated constructor stub
	}

	public CareEvaluationReport(int id, int memberId, int careEvaluationId, Date regDate, String content,
			int careEvaluationReportCategoryId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.careEvaluationId = careEvaluationId;
		this.regDate = regDate;
		this.content = content;
		CareEvaluationReportCategoryId = careEvaluationReportCategoryId;
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

	public int getCareEvaluationId() {
		return careEvaluationId;
	}

	public void setCareEvaluationId(int careEvaluationId) {
		this.careEvaluationId = careEvaluationId;
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

	public int getCareEvaluationReportCategoryId() {
		return CareEvaluationReportCategoryId;
	}

	public void setCareEvaluationReportCategoryId(int careEvaluationReportCategoryId) {
		CareEvaluationReportCategoryId = careEvaluationReportCategoryId;
	}

	@Override
	public String toString() {
		return "CareEvaluationReport [id=" + id + ", memberId=" + memberId + ", careEvaluationId=" + careEvaluationId
				+ ", content=" + content + ", CareEvaluationReportCategoryId=" + CareEvaluationReportCategoryId + "]";
	}
	
}
