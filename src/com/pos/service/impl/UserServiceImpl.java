package com.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.beans.Message;
import com.pos.dao.UserDao;
import com.pos.hibernate.beans.User;
import com.pos.service.UserService;
import com.pos.utils.SecurityUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private SecurityUtils securityUtils;

	@Override
	public Message add(User user) {
		// TODO Auto-generated method stub
		Message message = new Message();
		if (userDao.getUserByName(user.getName()) != null) {
			message.setStatus("Error");
			message.setContent("User " + user.getName() + " already exist");
		} else {
			String password = securityUtils.generateHash(user.getPswd());
			user.setPswd(password);
			if (userDao.addUser(user)) {
				message.setStatus("Success");
				message.setContent("User " + user.getName() + " added successfully");
			}
			else
			{
				message.setStatus("ERROR");
				message.setContent("Something Went Wrong.Please contact Lingesan");
			}
		}
		return message;
	}

}
