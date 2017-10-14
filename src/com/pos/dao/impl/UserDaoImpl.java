package com.pos.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pos.constants.QueryConstants;
import com.pos.dao.UserDao;
import com.pos.hibernate.beans.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean isValidUser(User user) {

		User tempUser = getUserByName(user.getName());
		if (tempUser == null)
			return false;
		return true;

	}

	@Override
	@Transactional
	public boolean addUser(User user){
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(user);
			session.flush();
		} catch (Exception exception) {
			return false;
		}
		return true;
	}
	@Override
	@Transactional
	public boolean updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(user);
			session.flush();
		} catch (Exception exception) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public User getUserByName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(QueryConstants.QUERY_GET_USER_BY_NAME);
		query.setParameter(QueryConstants.USER_NAME, userName);
		List<?> list = query.list();
		if (list == null)
			return null;
		if(list.isEmpty())
			return null;
		return (User)list.get(0);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(QueryConstants.QUERY_GET_ALL_USERS);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		return list;
	}
}
