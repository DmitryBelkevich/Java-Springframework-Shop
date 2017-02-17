package com.hard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hard.helpers.DateHelper;

@Controller
@RequestMapping(value = "/other")
public class OtherController {
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public String time() {
		return "other/time";
	}
	
	@RequestMapping(value = "/getCurrentTime", method = RequestMethod.GET)
	@ResponseBody
	public String getCurrentTime() {
		return DateHelper.getCurrentTime();
	}
	
	@RequestMapping(value = "/getCurrentYear", method = RequestMethod.GET)
	@ResponseBody
	public String getCurrentYear() {
		return DateHelper.getCurrentYear();
	}
}