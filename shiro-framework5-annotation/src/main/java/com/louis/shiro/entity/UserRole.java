package com.louis.shiro.entity;

/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */
public class UserRole implements java.io.Serializable {

	// Fields

	private Role role;
	private User user;

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}