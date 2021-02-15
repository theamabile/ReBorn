package com.reborn.web.service.name;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.name.NameDao;
import com.reborn.web.entity.care.CareView;
import com.reborn.web.entity.care.CareWish;
import com.reborn.web.entity.name.Choice;
import com.reborn.web.entity.name.Name;
import com.reborn.web.entity.name.NameView;
import com.reborn.web.entity.name.VoteView;

@Service
public class NameServiceImp implements NameService {

	@Autowired
	private NameDao nameDao;
	
	public NameServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int insert(Name name) {
		
		int result = nameDao.insert(name);
		
		return result;
	}

	@Override
	public int update(Name name) {
		int result = nameDao.update(name);
		
		return result;
	}


	@Override
	public int delete(long animalId, String name) {
		// TODO Auto-generated method stub
		return nameDao.delete(animalId, name);
	}
	

	@Override
	public Name get(long animalId, String name) {
		return nameDao.get(animalId, name);
	}

	@Override
	public List<Name> getList(int page, int size, String field, String query) {
		List<Name> list = null;
		
		// offset 계산 => limit 사용
		int offset = (page-1)*size;
		list = nameDao.getList(offset, size, field, query);
		
		return list;
	}	

	@Override
	public NameView getView(long animalId, String name) {
		// TODO Auto-generated method stub
		return nameDao.getView(animalId, name);
	}

	@Override
	public List<NameView> getViewList(int page, int size, String orderField, String orderQuery, String field, String query) {
		List<NameView> list = null;
		
		// offset 계산 => limit 사용
		int offset = (page-1)*size;
		list = nameDao.getViewList(offset, size, orderField, orderQuery, field, query);
		
		return list;
	}

	
	@Override
	public int getCount(String field, String query) {
		return nameDao.getCount(field, query);
	}

	@Override
	public NameView getBestName(long animalId) {
		// TODO Auto-generated method stub
		return nameDao.getBestName(animalId);
	}

	@Override
	public void getAddedListByMemberId(int memberId, List<VoteView> list) {
		
		List<Long> animalIdList = nameDao.getAddedIdsByMemberId(memberId, list);
		
		for(VoteView v : list) {			
			for(long addedId : animalIdList) {				
				long voteId = v.getAnimalId();
				if( voteId == addedId ) {
					v.setAdded(true);
					animalIdList.remove(addedId);
					break;
				}
			}
		}
		
	}

}
