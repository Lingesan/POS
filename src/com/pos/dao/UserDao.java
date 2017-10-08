package com.pos.dao;

import java.util.List;

import com.pos.hibernate.beans.User;

public interface UserDao {

	public boolean isValidUser(User user);

	public boolean addUser(User user);

	public User getUserByName(String userName);

	List<User> getAllUsers();

	boolean updateUser(User user);

}
