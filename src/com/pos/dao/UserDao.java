package com.pos.dao;

import com.pos.beans.UserBean;

public interface UserDao {

	public boolean isValidUser(UserBean user);

	public boolean addUser(UserBean user);

	public UserBean getUserByName(String userName);

}
