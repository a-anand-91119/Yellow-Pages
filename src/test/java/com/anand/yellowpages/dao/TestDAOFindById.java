package com.anand.yellowpages.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anand.yellowpages.configuration.SpringRootConfiguration;
import com.anand.yellowpages.domain.User;

/**
 * 
 * @author A Anand
 *
 */
public class TestDAOFindById {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfiguration.class);
		DAO dao = applicationContext.getBean(UserDAOImpl.class);
	
		
		User user = (User) dao.findById(new Long("2"));
		System.out.println(user);
		System.out.println("-------User Fetched--------");
	}
}
