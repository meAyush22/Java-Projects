package com.SelfSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainControllers {
	
	@GetMapping("/")
	public String Home() {
		return "home";
	}

}
