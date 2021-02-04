package com.reborn.web.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.member.TitleDao;
import com.reborn.web.entity.member.Title;

@Service
public class TitleServiceImp implements TitleService {

	
	@Autowired
	TitleDao titleDao;
	
	@Override
	public String get(int TitleId) {
		
		
		return titleDao.get(TitleId);
	}

}
