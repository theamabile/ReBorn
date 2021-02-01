package com.reborn.web.entity.member;

public class Authority {
	

	   private int id;
	   private String name;

	   
	   public Authority() {
		   
		   
	}

	public Authority(int id, String name) {
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
		return "Authority [id=" + id + ", name=" + name + "]";
	}
	   
	   
}
