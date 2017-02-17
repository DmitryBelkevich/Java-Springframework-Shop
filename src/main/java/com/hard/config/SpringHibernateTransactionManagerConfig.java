package com.hard.config;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Proxy
public class SpringHibernateTransactionManagerConfig {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Bean("transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		
		return hibernateTransactionManager;
	}
}