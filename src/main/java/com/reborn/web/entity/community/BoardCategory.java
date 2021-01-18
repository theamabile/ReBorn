package com.reborn.web.entity.community;

public class BoardCategory {

	private int id;
	private String name;
	
	public BoardCategory() {
		
	}

	public BoardCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}

	@Override
	public String toString() {
		return "BoardCategory [id=" + id + ", name=" + name + "]";
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


	
	
}
