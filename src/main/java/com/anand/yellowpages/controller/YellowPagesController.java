package com.anand.yellowpages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anand.yellowpages.utilities.Constants;

@Controller
public class YellowPagesController {

	@RequestMapping(Constants.URL_TEST)
	public String helloWorld() {
		return "hello"; // -> /WEB-INF/view/hello.jsp
	}
}
