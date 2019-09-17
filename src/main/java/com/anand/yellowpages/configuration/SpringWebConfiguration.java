package com.anand.yellowpages.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.anand.yellowpages.utilities.Constants;

/**
 * Spring MVC Layer Configuration, the Web Layer
 * 
 * @author A Anand
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.anand.yellowpages"})
@EnableWebMvc
public class SpringWebConfiguration implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setPrefix(Constants.WEB_RESOURCE_PREFIX);
		internalResourceViewResolver.setSuffix(Constants.WEB_RESOURCE_SUFFIX);
		return internalResourceViewResolver;
	}
}
