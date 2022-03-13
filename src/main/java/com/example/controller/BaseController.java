package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

	public BaseController() {

	}

	@GetMapping("/connect")
	public void connect() {

		System.out.println("Tested database connection");
	}
}
