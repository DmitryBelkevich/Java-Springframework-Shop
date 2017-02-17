package com.hard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
	SpringMvcConfig.class,	// optional
	SpringBeansConfig.class,
	SpringJdbcConfig.class,
	SpringJdbcTemplateConfig.class,
	SpringHibernateConfig.class,
	SpringHibernateTransactionManagerConfig.class,
	SpringSecurityConfig.class,
	SpringLocalizationConfig.class,
	SpringAopConfig.class,
})
public class SpringContextConfig {
	
}