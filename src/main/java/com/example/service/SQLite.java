package com.example.service;

import com.example.interfaces.ISQLite;
import com.example.model.Actor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLite implements ISQLite {

    @Override
    public Actor getActors() {
        Connection conn = null;
        Statement stmt = null;

        try {
            String url = "jdbc:sqlite:movies.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM actors;");
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getInt("movie_id") + "\t" +
                        rs.getString("imdb_id") + "\t" +
                        rs.getString("name"));
            }
            rs.close();
        } catch(Exception e) {
        }
        return null;
    }
}
