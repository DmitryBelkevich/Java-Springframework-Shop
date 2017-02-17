package com.hard.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringJdbcTemplateConfig {
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
}