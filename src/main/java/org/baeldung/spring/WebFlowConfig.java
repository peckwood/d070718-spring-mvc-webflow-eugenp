package org.baeldung.spring;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;


@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {
	@Autowired
	private WebMvcConfig webMvcConfig;
	
	@Bean
	public MvcViewFactoryCreator mvcViewFactoryCreator(){
		MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
		factoryCreator.setViewResolvers(Collections.singletonList(this.webMvcConfig.viewResolver()));
		factoryCreator.setUseSpringBeanBinding(true);
		return factoryCreator;
	}
	
	@Bean
	public FlowBuilderServices flowBuilderServices(){
		return getFlowBuilderServicesBuilder().setViewFactoryCreator(mvcViewFactoryCreator()).setDevelopmentMode(true).build();
	}
	
	//map the flow to [web context path]/activationFlow
	//for example: http://localhost:8080/spring-mvc-webflow/activationFlow
	@Bean
	public FlowDefinitionRegistry flowRegistry(){
		return getFlowDefinitionRegistryBuilder(flowBuilderServices()).addFlowLocation(
			"/WEB-INF/flows/activation-flow.xml", "activationFlow").build();
	}
	
	@Bean
	public FlowExecutor flowExecutor(){
		return getFlowExecutorBuilder(flowRegistry()).build();
	}
	
	
	
	
}
