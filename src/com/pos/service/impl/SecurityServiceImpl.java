package com.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.beans.Message;
import com.pos.dao.UserDao;
import com.pos.hibernate.beans.User;
import com.pos.service.SecurityService;
import com.pos.utils.SecurityUtils;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SecurityUtils securityUtils;
	@Override
	public Message checkCredentials(User user) {
		Message message = new Message();
		if(userDao.isValidUser(user))
		{
			String password = userDao.getUserByName(user.getName()).getPswd();
			if(password.equals(securityUtils.generateHash(user.getPswd())))
			{
				message.setStatus("SUCCESS");
				message.setContent("Login granted");
			}
			else
			{
				message.setStatus("ERROR");
				message.setContent("Invalid Login Credentials");
			}
		}else
		{
			message.setStatus("ERROR");
			message.setContent("The username is invalid");			
		}
		return message;
	}

}
