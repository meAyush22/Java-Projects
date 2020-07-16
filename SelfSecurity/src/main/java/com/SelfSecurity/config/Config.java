package com.SelfSecurity.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.SelfSecurity")
public class Config {
	
	public ViewResolver resolver() {
		
		InternalResourceViewResolver Resolver = new InternalResourceViewResolver();
		Resolver.setPrefix("/WEB-INF/view/");
		Resolver.setSuffix(".jsp");
		
		return Resolver;
	}

}
