package com.example.service;

import com.example.interfaces.IActorService;
import com.example.model.Actor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActorService implements IActorService {

    @Override
    public List<Actor> getActors() {
        Connection conn;
        Statement stmt;

        try {
            String url = "jdbc:sqlite:movies.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM actors;");
            List<Actor> actors = new ArrayList<>();
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setId(rs.getInt("id"));
                actor.setImdb_id(rs.getInt("imdb_id"));
                actor.setMovie_id(rs.getInt("movie_id"));
                actor.setName(rs.getString("name"));
                actors.add(actor);
            }
            rs.close();
            return actors;
        } catch(Exception e) {
        }
        return null;
    }
}
