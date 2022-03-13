package com.example.controller;

import com.example.interfaces.ISQLite;
import com.example.model.Actor;
import com.example.service.SQLite;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

	private ISQLite sql;
	public BaseController() {
		sql = new SQLite();
	}

	@GetMapping("/actors")
	public List<Actor> getActors() {
		List<Actor> actors = sql.getActors();
		System.out.println("Tested database connection");
		return actors;
	}
}
