package com.anand.yellowpages.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Root Configuration class, the Business Layer
 * 
 * @author A Anand
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.anand.yellowpages" })
public class SpringRootConfiguration {

}
