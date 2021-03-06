package com.anand.yellowpages.utilities;

/**
 * Constants Class
 * 
 * @author A Anand
 *
 */
public class Constants {
	
	public static final String WEB_RESOURCE_PREFIX = "/WEB-INF/view/";
	public static final String WEB_RESOURCE_SUFFIX = ".jsp";
	
	public static final String URL_ROOT = "/";
	public static final String URL_INDEX = "/index";
	public static final String URL_LOGIN = "/login";
	public static final String URL_DASHBOARD_USER = "/user/dashboard";
	public static final String URL_DASHBOARD_ADMIN = "/admin/dashboard";
	public static final String URL_LOGOUT = "/logout";
	public static final String URL_REGISTER = "/registration";
	public static final String URL_REGISTER_USER = "/register";
	public static final String URL_CONTACT_FORM = "/user/contactForm";
	public static final String URL_CONTACT_SAVE = "/user/saveContact";
	public static final String URL_CONTACT_LIST = "/user/contactList";
	public static final String URL_CONTACT_EDIT = "/user/editContact";
	public static final String URL_CONTACT_DELETE = "/user/deleteContact";
	public static final String URL_CONTACT_DELETE_BULK = "/user/bulkDeleteContact";
	public static final String URL_CONTACT_SEARCH = "/user/searchContact";
	public static final String URL_USERS_LIST = "/admin/usersList";
	public static final String URL_AJAX_TEST = "/ajaxTest";
	public static final String URL_AJAX_TEST_TIME = "/ajaxTestTime";
	public static final String URL_AJAX_LOGIN_STATUS = "/admin/changeUserLoginStatus";
	public static final String URL_USERNAME_AVAILABLE = "/isUsernameAvailable";
	
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/yellow_pages?serverTimezone=UTC";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	public static final String COMMA = ",";
	
}
