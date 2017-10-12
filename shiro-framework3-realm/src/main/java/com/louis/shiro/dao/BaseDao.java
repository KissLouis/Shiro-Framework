package com.louis.shiro.dao;

import java.sql.*;

import org.apache.log4j.Logger;


public class BaseDao {
	
	public static String CLASS_NAME = "com.mysql.jdbc.Driver";
	public static String URL = "jdbc:mysql://127.0.0.1:3306/shiro?useUnicode=true&amp;characterEncoding=UTF-8&amp;allowMultiQueries=true";;
	public static String USER_NAME ="root";
	public static String USER_PWD = "123456";

	private Connection conn;
	private PreparedStatement ps;

	private static Logger logger = Logger.getRootLogger();

	public void openConnection() throws SQLException {
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			logger.error("驱动加载失败", e);
		}
		
		//获得值
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
		}
	}

	public void release(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}

	public int update(String sql, Object... params) throws SQLException {
		logger.debug("执行SQL:" + sql);
		this.openConnection();
		ps = conn.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}
		int count = ps.executeUpdate();
		return count;
	}

	public ResultSet query(String sql, Object... params) throws SQLException {
		logger.debug("执行SQL:" + sql);
		this.openConnection();
		ps = conn.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}
		ResultSet rs = ps.executeQuery();
		return rs;
	}
}
