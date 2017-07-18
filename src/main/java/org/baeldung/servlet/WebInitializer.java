package org.baeldung.servlet;

import javax.servlet.ServletRegistration.Dynamic;

import org.baeldung.spring.WebFlowConfig;
import org.baeldung.spring.WebMvcConfig;
import org.baeldung.spring.WebMvcConfigLoadingWebflowWmlConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//pure JavaConfig for WebMvc and WebFlow
		//return new Class<?>[] {WebMvcConfig.class, WebFlowConfig.class};
		
		//JavaConfig WebMvc and XML WebFlow
		return new Class<?>[] {WebMvcConfigLoadingWebflowWmlConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	protected void customizeRegistration(final Dynamic registration){
		super.customizeRegistration(registration);
	}
	
}
