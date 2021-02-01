package com.reborn.web.entity.animal;

public class AnimalKind {
	private String cd;
	private String upKindCd;
	private String name;
	
	public AnimalKind() {
		// TODO Auto-generated constructor stub
	}
	
	public AnimalKind(String cd, String upKindCd, String name) {
		super();
		this.cd = cd;
		this.upKindCd = upKindCd;
		this.name = name;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getUpKindCd() {
		return upKindCd;
	}

	public void setUpKindCd(String upKindCd) {
		this.upKindCd = upKindCd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AnimalKind [cd=" + cd + ", upKindCd=" + upKindCd + ", name=" + name + "]";
	}
	
}
