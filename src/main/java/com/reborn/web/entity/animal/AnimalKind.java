package com.reborn.web.entity.animal;

public class AnimalKind {
	private String code;
	private String upKindCode;
	private String name;
	
	public AnimalKind() {
		// TODO Auto-generated constructor stub
	}
	
	public AnimalKind(String code, String upKindCode, String name) {
		super();
		this.code = code;
		this.upKindCode = upKindCode;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUpKindCode() {
		return upKindCode;
	}

	public void setUpKindCode(String upKindCode) {
		this.upKindCode = upKindCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AnimalKind [code=" + code + ", upKindCode=" + upKindCode + ", name=" + name + "]";
	}
	
}
