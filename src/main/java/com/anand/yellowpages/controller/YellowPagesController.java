package com.anand.yellowpages.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anand.yellowpages.command.LoginCommand;
import com.anand.yellowpages.command.RegistrationCommand;
import com.anand.yellowpages.command.SearchCommand;
import com.anand.yellowpages.domain.User;
import com.anand.yellowpages.exception.UserBlockedException;
import com.anand.yellowpages.services.UserService;
import com.anand.yellowpages.utilities.Constants;
import com.anand.yellowpages.utilities.ServiceConstants;

@Controller
public class YellowPagesController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {Constants.URL_INDEX, Constants.URL_ROOT})
	public String login(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		return "index";  // -> /WEB-INF/view/index.jsp
	}
	
	@RequestMapping(value = {Constants.URL_DASHBOARD_USER})
	public String userDashboard() {
		return "dashboard_user";  // -> /WEB-INF/view/dashboard_user.jsp
	}
	
	@RequestMapping(value = {Constants.URL_DASHBOARD_ADMIN})
	public String adminDashboard() {
		return "dashboard_admin";  // -> /WEB-INF/view/dashboard_admin.jsp
	}
	
	@RequestMapping(value = {Constants.URL_USERS_LIST})
	public String getUsersList(Model model) {
		model.addAttribute("usersList", userService.getAllUsers()); 
		model.addAttribute("searchCommand", new SearchCommand());
		return "users_list";  // -> /WEB-INF/view/users_list.jsp
	}
	
	@RequestMapping(value = {Constants.URL_LOGOUT})
	public String logoutUser(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:index?action=logout"; // -> /WEB-INF/view/index.jsp
	}
	
	@RequestMapping(value = {Constants.URL_LOGIN}, method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("loginCommand") LoginCommand loginCommand, Model model, HttpSession httpSession) {
		try {
			User loggedInUser = userService.login(loginCommand.getLoginUserName(), loginCommand.getLoginPassword());
			
			if(loggedInUser == null) {
				// adding error message and go back to login page
				model.addAttribute("errorMessage", "Invalid Credentials Provided.");
				return "index"; // -> /WEB-INF/view/index.jsp
				
			}else if(loggedInUser.getUserRole().equals(ServiceConstants.ROLE_ADMIN)) {
				addUserToSession(loggedInUser, httpSession);
				return "redirect:admin/dashboard";  // -> /WEB-INF/view/dashboard_admin.jsp
			}else if(loggedInUser.getUserRole().equals(ServiceConstants.ROLE_USER)) {
				addUserToSession(loggedInUser, httpSession);
				return "redirect:user/dashboard";  // -> /WEB-INF/view/dashboard_user.jsp
			}else {
				// adding error message and go back to login page
				model.addAttribute("errorMessage", "Invalid User Role. Please Contact Admin For Help.");
				return "index"; // -> /WEB-INF/view/index.jsp
			}
			
		} catch (UserBlockedException e) {
			// adding error message and go back to login page
			model.addAttribute("errorMessage", e.getMessage());
			return "index"; // -> /WEB-INF/view/index.jsp
		}
	}
	
	@RequestMapping(value = Constants.URL_REGISTER)
	public String registrationForm(Model model) {
		model.addAttribute("registrationCommand", new RegistrationCommand());
		return "registration"; // -> /WEB-INF/view/registration.jsp
	}
	
	@RequestMapping(value = Constants.URL_REGISTER_USER)
	public String registerUser(@ModelAttribute("registrationCommand") RegistrationCommand registrationCommand, Model model) {
		try {
			User user = registrationCommand.getUser();
			if(user != null) {
				user.setUserRole(ServiceConstants.ROLE_USER);
				user.setUserLoginStatus(ServiceConstants.LOGIN_STATUS_ACTIVE);
				userService.register(user);
				return "redirect:index?action=register"; // -> /WEB-INF/view/index.jsp
			}
			return "registration"; // -> /WEB-INF/view/registration.jsp
		} catch (DuplicateKeyException e) {
			model.addAttribute("errorMessage", "Username is already taken.");
			return "registration"; // -> /WEB-INF/view/registration.jsp
		}
	}
	
	/**
	 * Adds the logged in user to the http session
	 * 
	 * @param user
	 * 			the user who logged in successfully
	 * @param httpSession
	 * 			the http session
	 */
	private void addUserToSession(User user, HttpSession httpSession) {
		httpSession.setAttribute("loggedInUserId", user.getUserId());
		httpSession.setAttribute("loggedInUserRole", user.getUserRole());
	}
	
	@RequestMapping(value = Constants.URL_AJAX_TEST)
	public String ajaxTest() {
		return "ajax_test"; // -> /WEB-INF/view/ajax_test.jsp
	}
	
	@RequestMapping(value = Constants.URL_AJAX_TEST_TIME)
	@ResponseBody
	public String getTimeByAjax() {
		Date date = new Date();
		return date.toString();
	}
	
	@RequestMapping(value = Constants.URL_AJAX_LOGIN_STATUS)
	@ResponseBody
	public String updateUserLoginStatusByAjax(@RequestParam Long userId, @RequestParam Integer loginStatus) {
		System.out.println(userId +""+ loginStatus);
		try {
			userService.changeLoginStatus(userId, loginStatus);
			return "SUCCESS: User Login Status Changed";
		} catch (Exception e) {
			return "FAILURE: Error: " + e.getMessage();
		}
	}
	
	@RequestMapping(value = Constants.URL_USERNAME_AVAILABLE)
	@ResponseBody
	public String isUserNameAvailable(@RequestParam("username") String userNameToCheck) {
		try {
			if(userService.isUsernameAvailable(userNameToCheck))
				return "SUCCESS: Username Is Available";
			else
				return "FAILURE: Username Is Already Taken";
		} catch (Exception e) {
			return "FAILURE: Error: " + e.getMessage();
		}
	}
}
