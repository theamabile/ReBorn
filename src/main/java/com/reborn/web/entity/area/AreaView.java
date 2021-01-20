package com.reborn.web.entity.area;

public class AreaView {

	private String uprName;
	private int uprCd;
	private String orgName;
	private int orgCd;
	
	public AreaView() {
		// TODO Auto-generated constructor stub
	}

	public AreaView(String uprName, int uprCd, String orgName, int orgCd) {
		super();
		this.uprName = uprName;
		this.uprCd = uprCd;
		this.orgName = orgName;
		this.orgCd = orgCd;
	}

	public String getUprName() {
		return uprName;
	}

	public void setUprName(String uprName) {
		this.uprName = uprName;
	}

	public int getUprCd() {
		return uprCd;
	}

	public void setUprCd(int uprCd) {
		this.uprCd = uprCd;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(int orgCd) {
		this.orgCd = orgCd;
	}

	@Override
	public String toString() {
		return "AreaView [uprName=" + uprName + ", uprCd=" + uprCd + ", orgName=" + orgName + ", orgCd=" + orgCd + "]";
	}
	
}
