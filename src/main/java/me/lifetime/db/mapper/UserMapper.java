package me.lifetime.db.mapper;

import me.lifetime.entity.User;

public interface UserMapper {
	
	int insert(User user);
	
	int update(User user);
	
	User getUser(String fromUserName);
}


