package com.example.controller;

import com.example.database.SQLite;
import com.example.spec.ISQLite;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {


	private ISQLite sql;

	public BaseController() {
		this.sql = new SQLite();
	}

	@GetMapping("/connect")
	public void connect() {

		sql.testCanConnect();

		System.out.println("Tested database connection");
a	}
}
