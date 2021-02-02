package com.reborn.web.entity.community;

import java.util.Date;

public class CommentView extends Comment{

	private String nickname;
	
	public CommentView() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentView(int id, int memberId, int boardId, String content, Date regDate, String nickname) {
		super(id, memberId, boardId, content, regDate);
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "CommentView [nickname=" + nickname + ", toString()=" + super.toString() + "]";
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	

	
	
	
	
}
