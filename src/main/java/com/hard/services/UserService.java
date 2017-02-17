package com.hard.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hard.models.User;

public interface UserService extends ModelService<User>, UserDetailsService {
	
}