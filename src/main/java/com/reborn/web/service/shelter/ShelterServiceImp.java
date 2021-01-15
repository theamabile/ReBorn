package com.reborn.web.service.shelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.shelter.ShelterDao;

@Service
public class ShelterServiceImp implements ShelterService {
	
	@Autowired
	private ShelterDao shelterDao;
	
	@Override
	public int test() {
		return shelterDao.test();
	}
	
}
