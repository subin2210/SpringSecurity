package com.study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/leaders/internationalConference")
	public String showInternationConference() {
		return "internationalConference";
	}
	
	@GetMapping("/system/adminHomePage")
	public String showSystemAdmin() {
		return "systemAdmin";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "notAuthorized";
	}

}
