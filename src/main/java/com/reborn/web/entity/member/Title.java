package com.reborn.web.entity.member;

public class Title {
	private int id;
	private String name;

	public Title() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Title(int id, String name) {
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
		return "Title [id=" + id + ", name=" + name + "]";
	}
	
	

}
