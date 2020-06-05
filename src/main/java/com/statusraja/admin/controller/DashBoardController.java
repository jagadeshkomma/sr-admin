package com.statusraja.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class DashBoardController {

	private static final Logger logger = LoggerFactory.getLogger(DashBoardController.class);
	
	@GetMapping("/dashboard")
	public ModelAndView dashboard() {
		logger.info("Welcome to dashboard!..");
		ModelAndView model = new ModelAndView("/admin/dashboard");
		return model;
	}
}
