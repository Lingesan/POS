package com.pos.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.constants.ViewConstants;
import com.pos.controller.ViewController;
import com.pos.utils.ViewUtils;

@Controller
public class ViewControllerImpl implements ViewController{
	
	@Autowired
	private ViewUtils viewUtils;
	
	@Override
	@RequestMapping("home.do")
	public String homePage(HttpServletRequest request)
	{
		if(viewUtils.isSessionActive(request))
			return viewUtils.resolveView(request);
		else
			return ViewConstants.LOGIN_PAGE;
		
	}

}
