package com.louis.shiro.service;

import com.louis.shiro.dao.IUserDao;
import com.louis.shiro.dao.impl.UserDao;
import com.louis.shiro.entity.User;

public class UserService {

	IUserDao userDao = new UserDao();

	public User getUserName(String userName) {
		return userDao.getUserName(userName);
	}

}
