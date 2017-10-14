package com.louis.shiro.entity;

/**
 * RolePermission entity. @author MyEclipse Persistence Tools
 */
public class RolePermission implements java.io.Serializable {

	// Fields

	private Role role;
	private Permission permission;

	// Constructors

	/** default constructor */
	public RolePermission() {
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}