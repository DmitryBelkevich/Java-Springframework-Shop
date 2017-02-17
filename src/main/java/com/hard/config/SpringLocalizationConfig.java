package com.hard.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class SpringLocalizationConfig extends WebMvcConfigurerAdapter {
	@Bean("messageSource")
	public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource() {
		ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		
		reloadableResourceBundleMessageSource.setBasename("classpath:messages");
		reloadableResourceBundleMessageSource.setDefaultEncoding("Windows-1251");
		
		return reloadableResourceBundleMessageSource;
	}
	
	@Bean("localeResolver")
	public CookieLocaleResolver getCookieLocaleResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		
		cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		cookieLocaleResolver.setCookieName("my-locale-cookie");
		cookieLocaleResolver.setCookieMaxAge(10);
		
		return cookieLocaleResolver;
	}
	
	@Bean("localeChangeInterceptor")
	public LocaleChangeInterceptor getLocaleChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		
		localeChangeInterceptor.setParamName("lang");
		
		return localeChangeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getLocaleChangeInterceptor());
	}
}