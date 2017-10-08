/**
 * 
 */
package com.pos.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pos.constants.QueryConstants;
import com.pos.dao.InvoiceDao;
import com.pos.hibernate.beans.Invoice;
import com.pos.hibernate.beans.User;

/**
 * @author lingesan
 *
 */
@Repository
public class InvoiceDaoImpl implements InvoiceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean addInvoice(Invoice invoice) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(invoice);
			session.flush();
		} catch (Exception exception) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean updateInvoice(Invoice invoice) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(invoice);
			session.flush();
		} catch (Exception exception) {
			return false;
		}
		return true;
	}
	@Override
	@Transactional(readOnly=true)
	public User getInvoicebyBillNo(int billNo) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(QueryConstants.QUERY_GET_INVOICE_BY_ID);
		query.setParameter(QueryConstants.INVOICE_ID, billNo);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		if (list == null)
			return null;
		return list.get(0);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Invoice> getAllInvoices() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(QueryConstants.QUERY_GET_ALL_INVOICES);
		@SuppressWarnings("unchecked")
		List<Invoice> list = query.list();
		return list;
	}

}
