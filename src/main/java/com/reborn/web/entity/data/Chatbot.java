package com.reborn.web.entity.data;

public class Chatbot {
	private int id;
	private String title;
	private String linkName;
	private String link;
	private String files;
	private int memberId;
	
	public Chatbot() {
		// TODO Auto-generated constructor stub
	}
	
	public Chatbot(int id, String title, String linkName, String link, String files, int memberId) {
		this.id = id;
		this.title = title;
		this.linkName = linkName;
		this.link = link;
		this.files = files;
		this.memberId = memberId;
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

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Chatbot [id=" + id + ", title=" + title + ", linkName=" + linkName + ", link=" + link + ", files="
				+ files + ", memberId=" + memberId + "]";
	}
}
