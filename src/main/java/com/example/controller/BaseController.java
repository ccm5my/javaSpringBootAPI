package com.example.controller;

import com.example.interfaces.ISQLite;
import com.example.service.SQLite;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

	private ISQLite sql;
	public BaseController() {
		sql = new SQLite();
	}

	@GetMapping("/actors")
	public void getActors() {
		sql.getActors();
		System.out.println("Tested database connection");
	}
}
