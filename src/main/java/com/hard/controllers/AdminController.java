package com.hard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hard.models.Role;
import com.hard.models.User;
import com.hard.services.RoleService;
import com.hard.services.UserService;

@Controller
@RequestMapping(value = "/admin", method = RequestMethod.GET)
public class AdminController {
	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ModelAndView roles() {
		List<Role> roles = roleService.getAll();
		
		return new ModelAndView("admin/roles", "roles", roles);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView users() {
		List<User> users = userService.getAll();
		
		return new ModelAndView("admin/users", "users", users);
	}
}