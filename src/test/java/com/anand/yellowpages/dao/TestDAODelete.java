package com.anand.yellowpages.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anand.yellowpages.configuration.SpringRootConfiguration;

/**
 * 
 * @author A Anand
 *
 */
public class TestDAODelete {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfiguration.class);
		DAO dao = applicationContext.getBean(UserDAOImpl.class);
	
		
		dao.deleteById(new Long("1"));
		System.out.println("-------User Deleted--------");
		((ConfigurableApplicationContext)applicationContext).close();
	}
}
