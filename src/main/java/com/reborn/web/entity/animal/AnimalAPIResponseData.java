package com.reborn.web.entity.animal;

import java.util.List;

public class AnimalAPIResponseData {
	private List<Animal> list;
	private int totalCount;
	
	public AnimalAPIResponseData(List<Animal> list, int totalCount) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.totalCount = totalCount;
	}

	public List<Animal> getList() {
		return list;
	}
	
	public void setList(List<Animal> list) {
		this.list = list;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
