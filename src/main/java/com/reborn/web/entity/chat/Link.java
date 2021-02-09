package com.reborn.web.entity.chat;

public class Link {
	private int id;
	private String title;
	private String address;
	
		
	public Link() {
		// TODO Auto-generated constructor stub
	}
	

	public Link(int id, String title, String address) {
		super();
		this.id = id;
		this.title = title;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Link [id=" + id + ", title=" + title + ", address=" + address + "]";
	}
}
