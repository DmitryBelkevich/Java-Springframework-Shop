package com.hard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
	public UserController() {
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String accessDenied() {
		return "user/accessDenied";
	}
	
	@RequestMapping(value = "/technical_error", method = RequestMethod.GET)
	public String technicalError() {
		return "user/technicalError";
	}
}