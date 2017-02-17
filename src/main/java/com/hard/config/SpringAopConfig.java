package com.hard.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hard.services.ProductService;

@Configuration
@ComponentScan({
	"com.hard.recommends",
})
public class SpringAopConfig {
	@Bean("productServiceProxy")
	public ProxyFactoryBean getProxyFactoryBean() {
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		
		proxyFactoryBean.setTarget(ProductService.class);
		proxyFactoryBean.setInterceptorNames("email");
		
		return proxyFactoryBean;
	}
}