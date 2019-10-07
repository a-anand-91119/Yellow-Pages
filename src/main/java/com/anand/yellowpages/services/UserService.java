package com.anand.yellowpages.services;

import java.util.List;

import com.anand.yellowpages.domain.User;
import com.anand.yellowpages.exception.UserBlockedException;

/**
 * Interface specifies all Business operation for User entity
 * 
 * @author A Anand
 *
 */
public interface UserService {

	/**
	 * Method handles the registration task of the user
	 * 
	 * @param user
	 * 			the {@link User} to be registered
	 */
	public void register(User user);
	
	/**
	 * Method handles login operation using given credentials.
	 * On successful authentication the {@link User} object will be returned. If authentication fails the null will be returned.
	 * In case if the user account is blocked, then {@link UserBlockedException} will be thrown
	 * 
	 * @param loginName
	 * 			user login name
	 * @param loginPassword
	 * 			user login password
	 * @throws {@link UserBlockedException}
	 * 			if the User account is blocked
	 * @return {@link User} object if authentication succeeds, otherwise returns null
	 */
	public User login(String loginName, String loginPassword) throws UserBlockedException;
	
	/**
	 * Method returns details of all registered Users
	 * 
	 * @return
	 * 			all registered Users
	 */
	public List<User> getAllUsers();
	
	/**
	 * This method changes the loginstatus of user passed as argument
	 * 
	 * @param userId
	 * 			unique id of the user to be updated
	 * @param loginStatus
	 * 			new login status of the user
	 */
	public void changeLoginStatus(Long userId, Integer loginStatus);
	
	/**
	 * Checks whether the entered username is available or not
	 * 
	 * @param username
	 * 			the username to be checked
	 * @return true if username is not available, otherwise returns false
	 */
	public boolean isUsernameAvailable(String username);
}
