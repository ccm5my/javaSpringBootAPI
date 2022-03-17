package com.cameron.controller;

import com.cameron.interfaces.IActorService;
import com.cameron.interfaces.IMovieService;
import com.cameron.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {

	private IActorService actors;
	private IMovieService movies;
	
	@Autowired
	public ActorController(IActorService actors) {
		this.actors = actors;
	}

	@GetMapping("/actors")
	public List<Actor> getActors() {
		List<Actor> response = actors.getActors();
		System.out.println("getting actors");
		return response;
	}

	@PostMapping("/actors")
	public void addNewActor(@RequestBody Actor actor) {
		System.out.println("adding a new actor");
		actors.addNewActor(actor);
	}

	@PutMapping("/actors/{id}")
	public void updateActor(@PathVariable String id, @RequestBody Actor actor) {
		System.out.println("id " + id);
		actors.updateNewActor(actor);
	}



}
