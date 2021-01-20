package com.reborn.web.entity.care;

import java.util.Date;

public class Care {

	private String careRegNo;
	private String name;
	private boolean auth;
	private String tel;
	private String addr;
	private String jibunAddr;
	private String latitude;
	private String longitude;
	private Date dataStdDt;
	private String thumb;
	private int uprCd;
	private int orgCd;
	
	public Care() {
		// TODO Auto-generated constructor stub
	}

	public Care(String careRegNo, String name, boolean auth, String tel, String addr, String jibunAddr, String latitude,
			String longitude, Date dataStdDt, String thumb, int uprCd, int orgCd) {
		super();
		this.careRegNo = careRegNo;
		this.name = name;
		this.auth = auth;
		this.tel = tel;
		this.addr = addr;
		this.jibunAddr = jibunAddr;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dataStdDt = dataStdDt;
		this.thumb = thumb;
		this.uprCd = uprCd;
		this.orgCd = orgCd;
	}

	public String getCareRegNo() {
		return careRegNo;
	}

	public void setCareRegNo(String careRegNo) {
		this.careRegNo = careRegNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getJibunAddr() {
		return jibunAddr;
	}

	public void setJibunAddr(String jibunAddr) {
		this.jibunAddr = jibunAddr;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getDataStdDt() {
		return dataStdDt;
	}

	public void setDataStdDt(Date dataStdDt) {
		this.dataStdDt = dataStdDt;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public int getUprCd() {
		return uprCd;
	}

	public void setUprCd(int uprCd) {
		this.uprCd = uprCd;
	}

	public int getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(int orgCd) {
		this.orgCd = orgCd;
	}

	@Override
	public String toString() {
		return "Care [careRegNo=" + careRegNo + ", name=" + name + ", auth=" + auth + ", tel=" + tel + ", addr=" + addr
				+ ", jibunAddr=" + jibunAddr + ", latitude=" + latitude + ", longitude=" + longitude + ", dataStdDt="
				+ dataStdDt + ", thumb=" + thumb + ", uprCd=" + uprCd + ", orgCd=" + orgCd + "]";
	}
	
}
