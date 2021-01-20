package com.reborn.web.entity.care;

public class CareEvaluationReportCategory {

	private int id;
	private String name;
	
	public CareEvaluationReportCategory() {
		// TODO Auto-generated constructor stub
	}

	public CareEvaluationReportCategory(int id, String name) {
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
		return "CareEvaluationReportCategory [id=" + id + ", name=" + name + "]";
	}
	
}
