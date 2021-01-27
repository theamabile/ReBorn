package com.reborn.web.entity.animal;

import java.util.List;

public class AnimalUpKind {
	private String code;
	private String name;
	private List<AnimalKind> kindList;
	
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<AnimalKind> getKindList() {
		return kindList;
	}
	
	public void setKindList(List<AnimalKind> kindList) {
		this.kindList = kindList;
	}
	
	@Override
	public String toString() {
		return "AnimalUpKind [code=" + code + ", name=" + name + ", kindList=" + kindList + "]";
	}
	
}
