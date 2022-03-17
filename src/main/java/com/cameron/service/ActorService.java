package com.cameron.service;

import com.cameron.database.ConnectionFactory;
import com.cameron.interfaces.IActorService;
import com.cameron.model.Actor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService implements IActorService {
    @Override
    public List<Actor> getActors() {
        Statement stmt;

        try {
            Connection conn = ConnectionFactory.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM actors;");
            List<Actor> actors = new ArrayList<>();
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setId(rs.getInt("id"));
                actor.setImdb_id(rs.getString("imdb_id"));
                actor.setMovie_id(rs.getInt("movie_id"));
                actor.setName(rs.getString("name"));
                actors.add(actor);
            }
            rs.close();
            return actors;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public void addNewActor(Actor actor) {

        try {
            String sql = "INSERT INTO actors (id, movie_id, imdb_id, name) VALUES(?, ?, ?, ?)";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, actor.getId());
            stmt.setInt(2, actor.getMovie_id());
            stmt.setString(3, actor.getImdb_id());
            stmt.setString(4, actor.getName());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateNewActor(Actor actor) {
        try {
            String sql = "UPDATE actors SET movie_id=?, imdb_id=?, name=? where id = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, actor.getMovie_id());
            stmt.setString(2, actor.getImdb_id());
            stmt.setString(3, actor.getName());
            stmt.setInt(4, actor.getId());


            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
