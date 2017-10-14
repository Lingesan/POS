package com.pos.controller;

import javax.servlet.http.HttpServletRequest;

import com.pos.beans.Message;
import com.pos.hibernate.beans.User;

public interface SecurityController {

	public Message checkCredentials(User user,HttpServletRequest request);
	public boolean createSessionForUser(User user,HttpServletRequest request);
}
