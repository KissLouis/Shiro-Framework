package com.louis.shiro.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.louis.shiro.entity.User;

public interface IUserDao {

	/**
	 * 
	 * @title: getUserName
	 * @description: 根据用户名查找用户
	 * @param user
	 * @return
	 */
	public User getUserName(@Param("name") String userName);

	/**
	 * 
	 * @title: getRoles
	 * @description: 根据用户名查找该角色
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(@Param("name") String userName);

	/**
	 * 
	 * @title: getPermission
	 * @description: 根据用户名查找权限
	 * @param userName
	 * @return
	 */
	public Set<String> getPermission(@Param("name") String userName);

}
