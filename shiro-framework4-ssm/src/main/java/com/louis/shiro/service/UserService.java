package com.louis.shiro.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.shiro.dao.IUserDao;
import com.louis.shiro.entity.User;

@Service("userService")
public class UserService {

	@Autowired
	private IUserDao userDao;

	public User getUserName(String userName) {
		return userDao.getUserName(userName);
	}

	public Set<String> getRoles(String userName) {
		return userDao.getRoles(userName);
	}

	public Set<String> getPermission(String userName) {
		return userDao.getPermission(userName);
	}
}
