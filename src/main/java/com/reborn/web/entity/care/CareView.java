package com.reborn.web.entity.care;

import java.util.Date;

public class CareView extends Care{

	private boolean wish;
	private int wishCnt;
	private int reviewCnt;
	private int animalCnt;
	private double reviewScoreAvg;
	
	public CareView() {
		
	}

	public CareView(String careRegNo, String name, boolean auth, String tel, String addr, String jibunAddr, String latitude,
			String longitude, Date dataStdDt, String thumb, int uprCd, int orgCd, Boolean wish, int wishCnt, int reviewCnt, int animalCnt, double reviewScoreAvg) {
		super(careRegNo, name, auth, tel, addr, jibunAddr, latitude, longitude, dataStdDt, thumb, uprCd, orgCd);
		this.wish = wish;
		this.wishCnt = wishCnt;
		this.reviewCnt = reviewCnt;
		this.animalCnt = animalCnt;
		this.reviewScoreAvg = reviewScoreAvg;
	}
	
	public CareView(int wishCnt, int reviewCnt, int animalCnt, double reviewScoreAvg) {
		this.wishCnt = wishCnt;
		this.reviewCnt = reviewCnt;
		this.animalCnt = animalCnt;
		this.reviewScoreAvg = reviewScoreAvg;
	}
	
	public boolean getWish() {
		return wish;
	}

	public void setWish(boolean wish) {
		this.wish = wish;
	}

	public int getWishCnt() {
		return wishCnt;
	}

	public void setWishCnt(int wishCnt) {
		this.wishCnt = wishCnt;
	}

	public int getAnimalCnt() {
		return animalCnt;
	}

	public void setAnimalCnt(int animalCnt) {
		this.animalCnt = animalCnt;
	}
	
	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public double getReviewScoreAvg() {
		return reviewScoreAvg;
	}

	public void setReviewScoreAvg(double reviewScoreAvg) {
		this.reviewScoreAvg = reviewScoreAvg;
	}

	@Override
	public String toString() {
		return "CareView [wish=" + wish + ", wishCnt=" + wishCnt + ", reviewCnt=" + reviewCnt + ", animalCnt="
				+ animalCnt + ", reviewScoreAvg=" + reviewScoreAvg + "]";
	}

}
