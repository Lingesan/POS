package com.pos.service;

import com.pos.beans.Message;
import com.pos.hibernate.beans.User;

public interface SecurityService {

	public Message checkCredentials(User user);

}
