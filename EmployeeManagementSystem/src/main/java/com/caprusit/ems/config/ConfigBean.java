package com.caprusit.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.caprusit.ems")
public class ConfigBean extends WebMvcConfigurerAdapter {

	
	
	@Bean
	public ViewResolver configureViewResolver() {
	    InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
	    viewResolve.setPrefix("/WEB-INF/views/");
	    viewResolve.setSuffix(".jsp");

	    return viewResolve;
	}

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	   registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
	  configurer.enable();
	}
	
	
}


