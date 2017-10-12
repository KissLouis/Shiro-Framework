package com.louis.shiro.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.louis.shiro.dao.BaseDao;
import com.louis.shiro.dao.IUserDao;
import com.louis.shiro.entity.User;

/**
 * 
 * @Title: UserDao
 * @Description: 用户Dao层
 * @author Louis
 * @date 2017年10月12日
 */
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
		Set<String> roles = null;
		ResultSet rs = null;
		String sql = "SELECT r.name as name FROM USER u,role r ,user_role ur WHERE r.id=ur.rid AND u.id=ur.uid AND u.name = ?";
		try {
			rs = super.query(sql, userName);
			while (rs.next()) {
				roles = new HashSet<String>();
				roles.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}

	public Set<String> getPermission(String userName) {
		// TODO Auto-generated method stub
		Set<String> permissions = null;
		ResultSet rs = null;
		String sql = "SELECT p.url  FROM USER u,role r ,user_role ur,role_permission up,permission p WHERE r.id=ur.rid AND u.id=ur.uid AND r.id=up.rid AND p.id=up.pid AND  u.name = ? ";
		try {
			rs = super.query(sql, userName);
			while (rs.next()) {
				permissions = new HashSet<String>();
				permissions.add(rs.getString("url"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return permissions;
	}
}
