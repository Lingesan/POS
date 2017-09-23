package com.pos.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.pos.constants.SessionConstants;

@Component
public class ViewUtils {
	
	public boolean isSessionActive(HttpServletRequest request)
	{
		if(request.getSession(true).getAttribute(SessionConstants.user)!=null)
			return true;
		return false;
	}
	
	public String resolveView(HttpServletRequest request)
	{
		if(isSessionActive(request))
		{
			
		}
		return null;
	}
}
