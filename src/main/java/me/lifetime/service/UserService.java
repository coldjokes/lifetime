package me.lifetime.service;

import me.lifetime.db.mapper.UserMapper;
import me.lifetime.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public int insert(User user){
		return userMapper.insert(user);
	}
	
	public int update(User user){
		return userMapper.update(user);
	}
	public User getUser(String fromUserName){
		return userMapper.getUser(fromUserName);
	}
}


