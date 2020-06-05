package com.statusraja.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")
	public ModelAndView home() {
		logger.info("login page ....");
		ModelAndView model = new ModelAndView("login");
		model.setViewName("redirect:/login");
		return model;
	}

}
