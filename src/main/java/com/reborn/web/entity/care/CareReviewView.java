package com.reborn.web.entity.care;

import java.util.Date;

public class CareReviewView extends CareReview {

	private String nickname;
	
	public CareReviewView() {
		// TODO Auto-generated constructor stub
	}

	public CareReviewView(int id, String careRegNo, int memberId, String content, int score, Date regDate, String title, String nickname) {
		super(id, careRegNo, memberId, content, score, regDate, title);
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "CareReviewView [nickname=" + nickname + "]";
	}
	
}
