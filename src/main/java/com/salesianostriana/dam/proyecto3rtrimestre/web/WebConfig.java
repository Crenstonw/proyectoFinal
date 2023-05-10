package com.salesianostriana.dam.proyecto3rtrimestre.web;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
	@Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
	    registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
	}
}
