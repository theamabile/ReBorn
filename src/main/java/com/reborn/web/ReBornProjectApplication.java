package com.reborn.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ReBornProjectApplication extends SpringBootServletInitializer {

	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
		return builder.sources(ReBornProjectApplication.class); 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ReBornProjectApplication.class, args);
	}

}
