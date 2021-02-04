package com.reborn.web.dao.community;

import com.reborn.web.entity.community.Like;

public interface LikeDao {

	int getLikeCount(int id);

	int getCount(int id, int memberId);

	void delete(int id, int memberId);

	void insert(Like like);

}
