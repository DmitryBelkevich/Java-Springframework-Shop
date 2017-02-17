package com.hard.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {
	public static void main(String[] args) {
		String password = "1234";
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
		System.out.println(hashedPassword);
	}
}