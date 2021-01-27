package com.reborn.web.entity.care;

public class AnimalEntityTemp {

	private String noticeNo;
	private String popfile;
	
	public AnimalEntityTemp() {
		
	}

	public AnimalEntityTemp(String noticeNo, String popfile) {
		super();
		this.noticeNo = noticeNo;
		this.popfile = popfile;
	}

	public String getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getPopfile() {
		return popfile;
	}

	public void setPopfile(String popfile) {
		this.popfile = popfile;
	}

	@Override
	public String toString() {
		return "animalEntityTemp [noticeNo=" + noticeNo + ", popfile=" + popfile + "]";
	}
	
}
