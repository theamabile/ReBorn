package com.reborn.web.entity.care;

import java.util.Date;

public class CareView extends Care{

	private boolean wish;
	private int wishCnt;
	private int reviewCnt;
	private int animalCnt;
	
	public CareView() {
		
	}

	public CareView(String careRegNo, String name, boolean auth, String tel, String addr, String jibunAddr, String latitude,
			String longitude, Date dataStdDt, String thumb, int uprCd, int orgCd, Boolean wish, int wishCnt, int reviewCnt, int animalCnt) {
		super(careRegNo, name, auth, tel, addr, jibunAddr, latitude, longitude, dataStdDt, thumb, uprCd, orgCd);
		this.wish = wish;
		this.wishCnt = wishCnt;
		this.reviewCnt = reviewCnt;
		this.animalCnt = animalCnt;
	}
	
	public CareView(int wishCnt, int reviewCnt, int animalCnt) {
		this.wishCnt = wishCnt;
		this.reviewCnt = reviewCnt;
		this.animalCnt = animalCnt;
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

	public int getreviewCnt() {
		return reviewCnt;
	}

	public void setreviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public int getAnimalCnt() {
		return animalCnt;
	}

	public void setAnimalCnt(int animalCnt) {
		this.animalCnt = animalCnt;
	}

	@Override
	public String toString() {
		return "CareView [wishCnt=" + wishCnt + ", reviewCnt=" + reviewCnt + ", animalCnt=" + animalCnt + "]";
	}
	
}
