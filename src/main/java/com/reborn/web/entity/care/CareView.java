package com.reborn.web.entity.care;

import java.util.Date;

public class CareView extends Care{

	private boolean wish;
	private int wishCnt;
	private int evaluationCnt;
	private int animalCnt;
	
	public CareView() {
		
	}

	public CareView(String careRegNo, String name, boolean auth, String tel, String addr, String jibunAddr, String latitude,
			String longitude, Date dataStdDt, String thumb, int uprCd, int orgCd, Boolean wish, int wishCnt, int evaluationCnt, int animalCnt) {
		super(careRegNo, name, auth, tel, addr, jibunAddr, latitude, longitude, dataStdDt, thumb, uprCd, orgCd);
		this.wish = wish;
		this.wishCnt = wishCnt;
		this.evaluationCnt = evaluationCnt;
		this.animalCnt = animalCnt;
	}
	
	public CareView(int wishCnt, int evaluationCnt, int animalCnt) {
		this.wishCnt = wishCnt;
		this.evaluationCnt = evaluationCnt;
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

	public int getEvaluationCnt() {
		return evaluationCnt;
	}

	public void setEvaluationCnt(int evaluationCnt) {
		this.evaluationCnt = evaluationCnt;
	}

	public int getAnimalCnt() {
		return animalCnt;
	}

	public void setAnimalCnt(int animalCnt) {
		this.animalCnt = animalCnt;
	}

	@Override
	public String toString() {
		return "CareView [wishCnt=" + wishCnt + ", evaluationCnt=" + evaluationCnt + ", animalCnt=" + animalCnt + "]";
	}
	
}