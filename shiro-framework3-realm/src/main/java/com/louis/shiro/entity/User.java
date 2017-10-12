package com.louis.shiro.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String pwd;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public User(Integer id, String name, String pwd, Set<UserRole> userRoles) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.userRoles = userRoles;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}