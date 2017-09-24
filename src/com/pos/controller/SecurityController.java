package com.pos.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface SecurityController {

	public ModelAndView checkCredentials(HttpServletRequest request);
}
