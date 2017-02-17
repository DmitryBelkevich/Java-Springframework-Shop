package com.hard.helpers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthHelper {
	public static String getCurrentUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		
		return name;
	}
}