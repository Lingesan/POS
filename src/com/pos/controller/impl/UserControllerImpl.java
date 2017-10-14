package com.pos.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pos.beans.Message;
import com.pos.controller.UserController;
import com.pos.hibernate.beans.User;
import com.pos.service.UserService;

@Controller
@RequestMapping("users")
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Message addUser(@ModelAttribute("user") User user) {
		Message message = new Message();
		if (user == null || user.getName() == null || user.getName() == "") {
			message.setStatus("Error");
			message.setContent("Username cannot be empty");
			return message;
		}
		if (user.getPswd() == null||user.getPswd()=="") {
			message.setStatus("Error");
			message.setContent("Password cannot be empty");
			return message;
		}
		return userService.add(user);
	}

}
