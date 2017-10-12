package com.louis.shiro.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.louis.shiro.dao.BaseDao;
import com.louis.shiro.dao.IUserDao;
import com.louis.shiro.entity.User;

public class UserDao extends BaseDao implements IUserDao {

	public User getUserName(String userName) {
		// TODO Auto-generated method stub
		User user = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER WHERE NAME = ?";
		try {
			rs = super.query(sql, userName);
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public Set<String> getRoles(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getPermission(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
