package com.reborn.web.entity.animal;

import java.sql.Date;

// DB의 Animal 테이블과 매핑 되는 Animal 엔티티
public class Animal {
	private String sexCd;
	private String noticeNo;
	private String kindCd;
	private String careAddr;
	private String processState;
	private Date noticeSdt;
	private Date noticeEdt;
	private String weight;
	private String careNm;
	private long desertionNo;
	private String careTel;
	private String happenPlace;
	private String officetel;
	private String orgNm;
	private String popfile;
	private String neuterYn;
	private String specialMark;
	private String colorCd;
	private Date happenDt;
	private String age;
	
	// 못불러오는 경우가 있어서 제외
	//String chargeNm;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
//	public Animal(AnimalAPI apiAnimal) {
//		// TODO Auto-generated constructor stub
//		this.sexCd = apiAnimal.getSexCd();
//		this.noticeNo = apiAnimal.getNoticeNo();
//		this.kindId = apiAnimal.getKindId();
//		this.careAddr = apiAnimal.getCareAddr();
//		this.processState = apiAnimal.getProcessState();
//		this.noticeSdt = apiAnimal.getNoticeSdt();
//		this.weight = apiAnimal.getWeight();
//		this.careNm = apiAnimal.getCareNm();
//		this.desertionNo = apiAnimal.getDesertionNo();
//		this.careTel = apiAnimal.getCareTel();
//		this.happenPlace = apiAnimal.getHappenPlace();
//		this.officetel = apiAnimal.getOfficetel();
//		this.orgNm = apiAnimal.getOrgNm();
//		this.popfile = apiAnimal.getPopfile();
//		this.noticeEdt = apiAnimal.getNoticeEdt();
//		this.neuterYn = apiAnimal.getNeuterYn();
//		this.specialMark = apiAnimal.getSpecialMark();
//		this.colorCd = apiAnimal.getColorCd();
//		this.happenDt = apiAnimal.getHappenDt();
//		this.age = apiAnimal.getAge();
//	}
	
	
	public Animal(String sexCd, String noticeNo, String kindCd, String careAddr, String processState, Date noticeSdt,
			Date noticeEdt, String weight, String careNm, long desertionNo, String careTel, String happenPlace,
			String officetel, String orgNm, String popfile, String neuterYn, String specialMark, String colorCd,
			Date happenDt, String age) {
		super();
		this.sexCd = sexCd;
		this.noticeNo = noticeNo;
		this.kindCd = kindCd;
		this.careAddr = careAddr;
		this.processState = processState;
		this.noticeSdt = noticeSdt;
		this.noticeEdt = noticeEdt;
		this.weight = weight;
		this.careNm = careNm;
		this.desertionNo = desertionNo;
		this.careTel = careTel;
		this.happenPlace = happenPlace;
		this.officetel = officetel;
		this.orgNm = orgNm;
		this.popfile = popfile;
		this.neuterYn = neuterYn;
		this.specialMark = specialMark;
		this.colorCd = colorCd;
		this.happenDt = happenDt;
		this.age = age;
	}
	
	
	public String getSexCd() {
		return sexCd;
	}
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}	
	public String getKindCd() {
		return kindCd;
	}
	public void setKindCd(String kindCd) {
		this.kindCd = kindCd;
	}
	public String getCareAddr() {
		return careAddr;
	}
	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}
	public String getProcessState() {
		return processState;
	}
	public void setProcessState(String processState) {
		this.processState = processState;
	}
	public Date getNoticeSdt() {
		return noticeSdt;
	}
	public void setNoticeSdt(Date noticeSdt) {
		this.noticeSdt = noticeSdt;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getCareNm() {
		return careNm;
	}
	public void setCareNm(String careNm) {
		this.careNm = careNm;
	}
	public long getDesertionNo() {
		return desertionNo;
	}
	public void setDesertionNo(long desertionNo) {
		this.desertionNo = desertionNo;
	}
	public String getCareTel() {
		return careTel;
	}
	public void setCareTel(String careTel) {
		this.careTel = careTel;
	}
	public String getHappenPlace() {
		return happenPlace;
	}
	public void setHappenPlace(String happenPlace) {
		this.happenPlace = happenPlace;
	}
	public String getOfficetel() {
		return officetel;
	}
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	public String getOrgNm() {
		return orgNm;
	}
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
	public String getPopfile() {
		return popfile;
	}
	public void setPopfile(String popfile) {
		this.popfile = popfile;
	}
	public Date getNoticeEdt() {
		return noticeEdt;
	}
	public void setNoticeEdt(Date noticeEdt) {
		this.noticeEdt = noticeEdt;
	}
	public String getNeuterYn() {
		return neuterYn;
	}
	public void setNeuterYn(String neuterYn) {
		this.neuterYn = neuterYn;
	}
	public String getSpecialMark() {
		return specialMark;
	}
	public void setSpecialMark(String specialMark) {
		this.specialMark = specialMark;
	}
	public String getColorCd() {
		return colorCd;
	}
	public void setColorCd(String colorCd) {
		this.colorCd = colorCd;
	}
	public Date getHappenDt() {
		return happenDt;
	}
	public void setHappenDt(Date happenDt) {
		this.happenDt = happenDt;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
