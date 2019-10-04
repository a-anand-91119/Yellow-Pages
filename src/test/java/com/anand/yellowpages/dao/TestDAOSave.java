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
public class TestDAOSave {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfiguration.class);
		DAO dao = applicationContext.getBean(DAO.class);
		
		User user = new User();
		user.setUserAddress("UserAddress");
		user.setUserEmailAddress("asd@asd.com");
		user.setUserLoginName("username_2");
		user.setUserLoginStatus("2");
		user.setUserName("Anand_123");
		user.setUserPassword("********");
		user.setUserPhoneNumber("1111111111");
		user.setUserRole("2");
		
		dao.save(user);
		System.out.println("-------User Saved--------");
		
		((ConfigurableApplicationContext)applicationContext).close();
	}
}
