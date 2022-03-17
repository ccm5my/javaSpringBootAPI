package com.cameron.interfaces;

import com.cameron.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getMovies();

    void addNewMovie(Movie movie);
}
