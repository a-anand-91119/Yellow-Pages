package com.anand.yellowpages.dao;

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
public class TestDAOUpdate {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfiguration.class);
		DAO dao = applicationContext.getBean(DAO.class);
		
		User user = new User();
		user.setUserAddress("UserAddress");
		user.setUserEmailAddress("asd@asd.com");
		user.setUserLoginName("username");
		user.setUserLoginStatus("1");
		user.setUserName("A Anand");
		user.setUserPassword("********");
		user.setUserPhoneNumber("987654321");
		user.setUserRole("USER");
		user.setUserId(new Long("1"));
		
		dao.update(user);
		System.out.println("-------User Updated--------");
		
		((ConfigurableApplicationContext)applicationContext).close();
	}
}
