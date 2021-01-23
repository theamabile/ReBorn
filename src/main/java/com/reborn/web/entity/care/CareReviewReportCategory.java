package com.reborn.web.entity.care;

public class CareReviewReportCategory {

	private int id;
	private String name;
	
	public CareReviewReportCategory() {
		// TODO Auto-generated constructor stub
	}

	public CareReviewReportCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CareReviewReportCategory [id=" + id + ", name=" + name + "]";
	}
	
}
