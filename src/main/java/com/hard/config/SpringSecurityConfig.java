package com.hard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.hard.helpers.PasswordHelper;
import com.hard.services.UserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("passwordHelper")
	private PasswordHelper passwordHelper;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/cabinet**").access("isAuthenticated()")
			.antMatchers("/admin**").access("hasRole('ADMIN')");
		
		http.formLogin()
			.loginPage("/user/login")
			.loginProcessingUrl("/auth")
			.usernameParameter("username")
			.passwordParameter("password")
			.defaultSuccessUrl("/", true)
			.failureUrl("/user/login?error=incorrectLoginPassword");
		
		http.exceptionHandling()
			.accessDeniedPage("/user/access_denied");
		
		http.logout()
			.logoutUrl("/logout**");
	}
	
	@Autowired
	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setUserDetailsService(userService);
		daoAuthenticationProvider.setPasswordEncoder(passwordHelper);
		
		auth
			.authenticationProvider(daoAuthenticationProvider);
	}
}