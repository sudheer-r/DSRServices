package com.bus.service.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bus.service.*")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

	/*
	 * @Override public void addViewControllers(ViewControllerRegistry registry)
	 * { super.addViewControllers(registry);
	 * registry.addRedirectViewController("register", "register"); }
	 */

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().prefix("/WEB-INF/jsp/").suffix(".jsp");
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}


	@Bean("messageSource")
	public MessageSource createMessageSource(){
		ResourceBundleMessageSource source=new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}

}
