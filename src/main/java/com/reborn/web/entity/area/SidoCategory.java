package com.reborn.web.entity.area;

public class SidoCategory {

	private int uprCd;
	private String name;
	
	public SidoCategory() {
		
	}

	public SidoCategory(int uprCd, String name) {
		super();
		this.uprCd = uprCd;
		this.name = name;
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

	@Override
	public String toString() {
		return "SidoCategory [uprCd=" + uprCd + ", name=" + name + "]";
	}
	
}
