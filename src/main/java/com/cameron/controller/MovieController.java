package com.cameron.controller;

import com.cameron.interfaces.IActorService;
import com.cameron.interfaces.IMovieService;
import com.cameron.model.Actor;
import com.cameron.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

	private IActorService actors;
	private IMovieService movies;
	
	@Autowired
	public ActorController(IActorService actors, IMovieService movies) {
		this.actors = actors;
		this.movies = movies;
	}

	@GetMapping("/actors")
	public List<Actor> getActors() {
		List<Actor> response = actors.getActors();
		System.out.println("getting actors");
		return response;
	}



	@GetMapping("/movies")
	public List<Movie> getMovies() {
		List<Movie> response = movies.getMovies();
		System.out.println("Grabbed movies");
		return response;
	}


}
