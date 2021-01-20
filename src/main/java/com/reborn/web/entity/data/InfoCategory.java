package com.reborn.web.entity.data;

public class InfoCategory {
	private int id;
	private String name;
	
	
	public InfoCategory() {
		// TODO Auto-generated constructor stub
	}
	
	public InfoCategory(int id, String name) {
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
		return "InfoCategory [id=" + id + ", name=" + name + "]";
	}
	
	
}
