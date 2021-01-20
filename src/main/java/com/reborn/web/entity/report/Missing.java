package com.reborn.web.entity.report;

import java.util.Date;

public class Missing {
	private int id; 
	private int memberId;
	private String title;
	private String content;
	private Date regDate;
	private int hitCnt;
	private String missingDate;
	private String feature;
	private String location;
	private String breed;
	private String files;
	
	public Missing() {
		// TODO Auto-generated constructor stub
	}

	public Missing(int id, int memberId, String title, String content, Date regDate, int hitCnt, String missingDate,
			String feature, String location, String breed, String files) {
		this.id = id;
		this.memberId = memberId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hitCnt = hitCnt;
		this.missingDate = missingDate;
		this.feature = feature;
		this.location = location;
		this.breed = breed;
		this.files = files;
	}

	@Override
	public String toString() {
		return "Missing [id=" + id + ", memberId=" + memberId + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", hitCnt=" + hitCnt + ", missingDate=" + missingDate + ", feature="
				+ feature + ", location=" + location + ", breed=" + breed + ", files=" + files + "]";
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

	public String getMissingDate() {
		return missingDate;
	}

	public void setMissingDate(String missingDate) {
		this.missingDate = missingDate;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
}
