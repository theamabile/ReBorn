package com.reborn.web.entity.animal;

import java.util.List;

public class AnimalUpKind {
	private String cd;
	private String name;
	private List<AnimalKind> kindList;
	
	
	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
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
		return "AnimalUpKind [cd=" + cd + ", name=" + name + ", kindList=" + kindList + "]";
	}
	
}
