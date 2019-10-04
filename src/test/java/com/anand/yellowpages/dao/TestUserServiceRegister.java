package com.anand.yellowpages.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anand.yellowpages.configuration.SpringRootConfiguration;
import com.anand.yellowpages.domain.User;
import com.anand.yellowpages.services.UserService;
import com.anand.yellowpages.utilities.ServiceConstants;

/**
 * 
 * @author A Anand
 *
 */
public class TestUserServiceRegister {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfiguration.class);
		UserService userService = applicationContext.getBean(UserService.class);
		
		User user = new User();
		user.setUserAddress("Service Test");
		user.setUserEmailAddress("asd@asd.com");
		user.setUserLoginName("username_123");
		user.setUserLoginStatus(ServiceConstants.LOGIN_STATUS_ACTIVE);
		user.setUserName("Service Test");
		user.setUserPassword("********");
		user.setUserPhoneNumber("1111111111");
		user.setUserRole(ServiceConstants.ROLE_ADMIN);
		
		userService.register(user);
		System.out.println("-------User Registered Successfully--------");
		
		((ConfigurableApplicationContext)applicationContext).close();
	}
}
