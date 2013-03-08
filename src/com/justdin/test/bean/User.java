package com.justdin.test.bean;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String username;
	private String password;
	private Short enabled;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, Short enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Short getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}

}