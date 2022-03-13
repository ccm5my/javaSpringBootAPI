package com.example.controller;

import com.example.interfaces.IActorService;
import com.example.interfaces.IMovieService;
import com.example.model.Actor;
import com.example.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

	private IActorService actors;
	private IMovieService movies;

	@Autowired
	public BaseController(IActorService actors, IMovieService movies) {
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
