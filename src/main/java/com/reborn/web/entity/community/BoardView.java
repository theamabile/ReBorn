package com.reborn.web.entity.community;

import java.util.Date;

public class BoardView extends Board {

	private String category;
	private String nickname;
	private int like;
	private int comment;
	
	public BoardView() {
		// TODO Auto-generated constructor stub
	}

	public BoardView(int id, String title, String content, Date regDate, String files, int hitCnt, String category, String nickname, int like, int comment) {
		super(id, title, content, regDate, files, hitCnt);
		this.category = category;
		this.nickname = nickname;
		this.like = like;
		this.comment = comment;
	}
	//insert를 위한 생성자.
	public BoardView(String title, String content, String category) {
		super(title, content);
		this.category = category;
	}

	@Override
	public String toString() {
		return "BoardView [category=" + category + ", nickname=" + nickname + ", like=" + like + ", comment=" + comment
				+ "]";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}
	
	
	
	
	
	
}
