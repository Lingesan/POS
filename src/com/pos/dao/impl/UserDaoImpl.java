package com.pos.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.beans.UserBean;
import com.pos.constants.QueryConstants;
import com.pos.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean isValidUser(UserBean user) {

		UserBean tempUser = getUserByName(user.getUserName());
		if (tempUser == null)
			return false;
		return true;

	}

	@Override
	public boolean addUser(UserBean user) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(user);
			session.flush();
			transaction.commit();
		} catch (Exception exception) {
			return false;
		}
		return true;
	}

	@Override
	public UserBean getUserByName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(QueryConstants.GET_USER_BY_NAME);
		query.setParameter(QueryConstants.USER_NAME, userName);
		List<UserBean> list = query.list();
		if (list == null)
			return null;
		return list.get(0);
	}
}
