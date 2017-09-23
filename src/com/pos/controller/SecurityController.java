package com.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/security")
public class SecurityController {

	@PostMapping("/login.do")
	public ModelAndView login()
	{
		return null;
		
	}
	

	
}
