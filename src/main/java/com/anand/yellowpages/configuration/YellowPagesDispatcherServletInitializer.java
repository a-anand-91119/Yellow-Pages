package com.anand.yellowpages.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.anand.yellowpages.utilities.Constants;

/**
 * The Web Application Servlet Initializer
 * @author A Anand
 *
 */
public class YellowPagesDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringRootConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringWebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {Constants.URL_ROOT};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext); // mandatory for spring framework
		// for global task, when required
	}
	
}
