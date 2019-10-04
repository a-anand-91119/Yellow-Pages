package com.anand.yellowpages.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anand.yellowpages.command.LoginCommand;
import com.anand.yellowpages.command.RegistrationCommand;
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
	public String registerUser(@ModelAttribute("registrationCommand") RegistrationCommand registrationCommand) {
		User user = registrationCommand.getUser();
		user.setUserRole(ServiceConstants.ROLE_USER);
		user.setUserLoginStatus(ServiceConstants.LOGIN_STATUS_ACTIVE);
		userService.register(user);
		return "redirect:index?action=register"; // -> /WEB-INF/view/index.jsp
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
}
