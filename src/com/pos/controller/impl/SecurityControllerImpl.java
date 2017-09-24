package com.pos.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pos.controller.SecurityController;

@Controller
@RequestMapping("security")
public class SecurityControllerImpl implements SecurityController{

	@Override
	@PostMapping("/checkCredentials.do")
	public ModelAndView checkCredentials(HttpServletRequest request)
	{
		return null;
		
	}


	
}
