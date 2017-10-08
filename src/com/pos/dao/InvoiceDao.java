/**
 * 
 */
package com.pos.dao;

import java.util.List;

import com.pos.hibernate.beans.Invoice;
import com.pos.hibernate.beans.User;

/**
 * @author lingesan
 *
 */
public interface InvoiceDao {

	boolean addInvoice(Invoice invoice);

	User getInvoicebyBillNo(int billNo);

	List<Invoice> getAllInvoices();

	boolean updateInvoice(Invoice invoice);

}
