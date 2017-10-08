package com.pos.constants;

public class QueryConstants {
	
	public static final String QUERY_GET_USER_BY_NAME = "from User where name =:name";
	public static final String USER_NAME = "name";
	public static final String INVOICE_ID = "billNo";
	public static final String QUERY_GET_INVOICE_BY_ID = "from Invoice where billNo =:billNo";
	public static final String QUERY_GET_ALL_USERS = "from User";
	public static final String QUERY_GET_ALL_INVOICES = "from Invoice";

}
