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
public class MovieController {

	private IMovieService movies;

	@Autowired
	public MovieController(IMovieService movies) {
		this.movies = movies;
	}

	@GetMapping("/movies")
	public List<Movie> getMovies() {
		List<Movie> response = movies.getMovies();
		System.out.println("Grabbed movies");
		return response;
	}


}
