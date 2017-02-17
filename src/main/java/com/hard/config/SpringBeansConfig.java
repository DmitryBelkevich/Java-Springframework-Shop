package com.hard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
	"com.hard.services.impl",
	"com.hard.dao.impl",
	"com.hard.helpers",
})
public class SpringBeansConfig {
	
}