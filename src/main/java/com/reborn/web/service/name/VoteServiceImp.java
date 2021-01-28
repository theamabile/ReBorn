package com.reborn.web.service.name;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.name.VoteDao;
import com.reborn.web.entity.name.Vote;
import com.reborn.web.entity.name.VoteView;

@Service
public class VoteServiceImp implements VoteService{
	
	@Autowired
	private VoteDao voteDao;
	
	@Override
	public int insert(Vote vote) {
		int result = voteDao.insert(vote);
		
		return result;
	}

	@Override
	public int update(Vote vote) {
		int result = voteDao.update(vote);
		
		return result;
	}

	@Override
	public int delete(long animalId) {
		int result = voteDao.delete(animalId);
		
		return result;
	}

	@Override
	public int deleteAll(long[] animalIds) {
		int result = voteDao.deleteAll(animalIds);
		
		return result;
	}

	@Override
	public Vote get(long animalId) {
		return voteDao.get(animalId);
	}
	
	@Override
	public List<Vote> getList(int page, int size, String field, String query) {
		List<Vote> list = null;
		
		// offset 계산 => limit 사용
		int offset = (page-1)*size;
		list = voteDao.getList(offset, size, field, query);
		
		return list;
	}


	@Override
	public VoteView getView(long animalId) {
		// TODO Auto-generated method stub
		return voteDao.getView(animalId);
	}
	
	@Override
	public List<VoteView> getViewList(int page, int size, String orderField, String orderQuery, String field, String query) {
		List<VoteView> list = null;
		
		// offset 계산 => limit 사용
		int offset = (page-1)*size;
		System.out.printf("page:%d / size:%d / orderField:%s / orderQuery:%s / field:%s/ query:%s\n"
				, page, size, orderField, orderQuery, field, query);
		
		
		list = voteDao.getViewList(offset, size, orderField, orderQuery, field, query);
		

		
		for(VoteView v : list) {
			System.out.println(v.getAnimalId());
		}
		
		return list;
	}

	@Override
	public int getCount(String field, String query) {
		return voteDao.getCount(field, query);
	}

	@Override
	public Vote getLast() {
		// TODO Auto-generated method stub
		return voteDao.getLast();
	}
}
