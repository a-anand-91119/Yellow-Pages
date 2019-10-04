package com.anand.yellowpages.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.anand.yellowpages.utilities.Constants;

/**
 * Spring Root Configuration class, the Business Layer
 * 
 * @author A Anand
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.anand.yellowpages.dao, com.anand.yellowpages.services" })
public class SpringRootConfiguration {

	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(Constants.DB_DRIVER);
		basicDataSource.setUrl(Constants.DB_URL);
		basicDataSource.setUsername(Constants.DB_USERNAME);
		basicDataSource.setPassword(Constants.DB_PASSWORD);
		basicDataSource.setMaxActive(2);
		basicDataSource.setInitialSize(1);
		basicDataSource.setTestOnBorrow(true);
		basicDataSource.setValidationQuery("Select 1");
		return basicDataSource;
	}
}
