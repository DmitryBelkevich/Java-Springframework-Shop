package com.hard.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringHibernateConfig {
	@Autowired
	private DataSource dataSource;
	
	@Value("${db.hibernate.dialect}")
	private String dialect;
	
	@Value("${db.hibernate.show_sql}")
	private String showSql;
	
	@Value("${db.current_session_context_class}")
	private String currentSessionContextClass;
	
	@Value("${db.hibernate.hbm2ddl.auto}")
	private String hbm2ddlAuto;
	
	@Value("${db.hibernate.enable_lazy_load_no_trans}")
	private String enableLazyLoadNoTrans;
	
	@Bean("sessionFactory")
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		
		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setPackagesToScan("com.hard.models");
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", dialect);
		hibernateProperties.setProperty("hibernate.show_sql", showSql);
		hibernateProperties.setProperty("current_session_context_class", currentSessionContextClass);
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
		hibernateProperties.setProperty("hibernate.enable_lazy_load_no_trans", enableLazyLoadNoTrans);
		
		localSessionFactoryBean.setHibernateProperties(hibernateProperties);
		
		return localSessionFactoryBean;
	}
}