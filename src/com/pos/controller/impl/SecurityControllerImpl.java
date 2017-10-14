package com.pos.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pos.beans.Message;
import com.pos.constants.ViewConstants;
import com.pos.controller.SecurityController;
import com.pos.hibernate.beans.User;
import com.pos.service.SecurityService;

@Controller
@RequestMapping("security")
public class SecurityControllerImpl implements SecurityController {

	@Autowired
	private SecurityService securityService;

	@Override
	@PostMapping("/checkCredentials.do")
	@ResponseBody
	public Message checkCredentials(@ModelAttribute("user") User user, HttpServletRequest request) {
		Message message = null;
		if (null == user) {
			message = new Message("ERROR", "User is NULL");
			return message;
		}
		if (user.getName() == null || ("".equals(user.getName()))) {

			message = new Message("ERROR", "Username is empty");
			return message;
		}
		message = securityService.checkCredentials(user);
		if (!message.getStatus().equals("SUCCESS"))
			return message;
		if (createSessionForUser(user, request))
			message = new Message("REDIRECT", ViewConstants.HOME_PAGE);
		else
			message = new Message("REDIRECT", ViewConstants.ERROR_PAGE);
			return message;

	}

	@Override
	public boolean createSessionForUser(User user, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
		} catch (Exception exception) {
			return false;
		}
		return true;
	}

}
