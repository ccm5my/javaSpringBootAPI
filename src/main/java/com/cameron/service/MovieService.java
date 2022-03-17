package com.cameron.service;

import com.cameron.database.ConnectionFactory;
import com.cameron.interfaces.IMovieService;
import com.cameron.model.Movie;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                movie.setImdb_id(rs.getString("imdb_id"));
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

    @Override
    public void addNewMovie(Movie movie) {
        try {
            String sql = "INSERT INTO movies (id, imdb_id, title, director, year, rating, genres, runtime, country, language, imdb_score, imdb_votes, metacritic_score) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, movie.getId());
            stmt.setString(2, movie.getImdb_id());
            stmt.setString(3, movie.getTitle());
            stmt.setString(4, movie.getDirector());
            stmt.setInt(5, movie.getYear());
            stmt.setInt(6, movie.getRating());
            stmt.setString(7, movie.getGenres());
            stmt.setInt(8, movie.getRuntime());
            stmt.setString(9, movie.getCountry());
            stmt.setString(10, movie.getLanguage());
            stmt.setInt(11, movie.getImdb_score());
            stmt.setInt(12, movie.getImdb_votes());
            stmt.setInt(13, (int) movie.getMetacritic_score());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
