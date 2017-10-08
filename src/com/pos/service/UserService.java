package com.pos.service;

import com.pos.beans.Message;
import com.pos.hibernate.beans.User;

public interface UserService {

	Message add(User user);

}
