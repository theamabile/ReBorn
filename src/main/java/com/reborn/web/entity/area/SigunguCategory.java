package com.reborn.web.entity.area;

public class SigunguCategory {

	private int uprCd;
	private String name;
	private int orgCd;
	
	public SigunguCategory() {
		
	}

	public SigunguCategory(int uprCd, String name, int orgCd) {
		super();
		this.uprCd = uprCd;
		this.name = name;
		this.orgCd = orgCd;
	}

	public int getUprCd() {
		return uprCd;
	}

	public void setUprCd(int uprCd) {
		this.uprCd = uprCd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(int orgCd) {
		this.orgCd = orgCd;
	}

	@Override
	public String toString() {
		return "SigunguCategory [uprCd=" + uprCd + ", name=" + name + ", orgCd=" + orgCd + "]";
	}
	
}
