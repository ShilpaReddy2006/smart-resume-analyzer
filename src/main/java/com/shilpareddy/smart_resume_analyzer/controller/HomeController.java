package com.shilpareddy.smart_resume_analyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
	@GetMapping("/ping")
	public String ping() {
		return "smart resume analyzer is running";
	}

}
