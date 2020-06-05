package com.statusraja.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	
	@GetMapping(value="/login")
	public ModelAndView login() {
		System.out.println("Welcome to login page!..");
		ModelAndView model = new ModelAndView("login");

		return model;
	}
	

}
