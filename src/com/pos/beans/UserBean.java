package com.pos.beans;

import java.math.BigInteger;

public class UserBean {
	
	private String userName;
	private String passwordHash;
	private BigInteger permissions;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public BigInteger getPermissions() {
		return permissions;
	}
	public void setPermissions(BigInteger permissions) {
		this.permissions = permissions;
	}
	

}
