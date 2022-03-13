package com.cameron.service;

import com.cameron.database.ConnectionFactory;
import com.cameron.interfaces.IMovieService;
import com.cameron.model.Movie;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Override
    public List<Movie> getMovies() {
        Statement stmt;

        try {
            Connection conn = ConnectionFactory.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies;");
            List<Movie> movies = new ArrayList<>();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setImdb_id(rs.getInt("imdb_id"));
                movie.setDirector(rs.getString("director"));
                movie.setCountry(rs.getString("country"));
                movies.add(movie);
            }
            rs.close();
            return movies;
        } catch (Exception e) {

        }
        return null;
    }
}
