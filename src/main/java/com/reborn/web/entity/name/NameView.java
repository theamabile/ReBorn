package com.reborn.web.entity.name;

public class NameView extends Name{
	private int choiceCnt;
	private String writerNickname;
	
	
	public int getChoiceCnt() {
		return choiceCnt;
	}

	public void setChoiceCnt(int choiceCnt) {
		this.choiceCnt = choiceCnt;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	@Override
	public String toString() {
		return "NameView [choiceCnt=" + choiceCnt + ", writerNickname=" + writerNickname + "]";
	}
	
}
