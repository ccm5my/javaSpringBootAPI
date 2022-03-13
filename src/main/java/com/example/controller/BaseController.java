package com.example.controller;

import com.example.interfaces.IActorService;
import com.example.model.Actor;
import com.example.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

	private IActorService actors;

	@Autowired
	public BaseController(IActorService actors) {
		this.actors = actors;
	}

	@GetMapping("/actors")
	public List<Actor> getActors() {
		List<Actor> response = actors.getActors();
		System.out.println("Tested database connection");
		return response;
	}
}
