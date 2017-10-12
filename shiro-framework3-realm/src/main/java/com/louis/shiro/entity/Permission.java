package com.louis.shiro.entity;

import java.util.HashSet;
import java.util.Set;

public class Permission implements java.io.Serializable {

	// Fields

	private Integer id;
	private String url;
	private String name;
	private Set<RolePermission> rolePermissions = new HashSet<RolePermission>(0);

	// Constructors

	/** default constructor */
	public Permission() {
	}

	/** minimal constructor */
	public Permission(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Permission(Integer id, String url, String name,
			Set<RolePermission> rolePermissions) {
		this.id = id;
		this.url = url;
		this.name = name;
		this.rolePermissions = rolePermissions;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RolePermission> getRolePermissions() {
		return this.rolePermissions;
	}

	public void setRolePermissions(Set<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

}