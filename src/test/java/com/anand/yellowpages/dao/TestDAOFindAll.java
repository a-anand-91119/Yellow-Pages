package com.anand.yellowpages.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anand.yellowpages.configuration.SpringRootConfiguration;
import com.anand.yellowpages.domain.User;

/**
 * 
 * @author A Anand
 *
 */
public class TestDAOFindAll {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfiguration.class);
		DAO dao = applicationContext.getBean(UserDAOImpl.class);
	
		
		List<?> result = dao.findAll();
		for(Object user : result) {
			System.out.println(((User)user).toString());
		}
		
		System.out.println("-------Users Fetched--------");
		((ConfigurableApplicationContext)applicationContext).close();
	}
}
