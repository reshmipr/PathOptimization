package com.telstra.optimisepath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/pathOptimizer")
	public String home() {
		return "index";
	}
}
