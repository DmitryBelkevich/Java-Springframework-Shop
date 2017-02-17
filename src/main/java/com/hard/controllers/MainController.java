package com.hard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hard.helpers.AuthHelper;

@Controller
public class MainController {
	@RequestMapping(value = { "/", "/main", "/home" }, method = RequestMethod.GET)
	public String main(ModelMap modelMap) {
		String username = AuthHelper.getCurrentUsername();
		
		modelMap.addAttribute("username", username);
		
		return "main/main";
	}
}