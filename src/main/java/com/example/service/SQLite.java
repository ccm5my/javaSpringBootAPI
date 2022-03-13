package com.example.service;

import com.example.interfaces.ISQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLite implements ISQLite {

    @Override
    public void connect() {
        Connection conn = null;
        Statement stmt = null;

        try {
            String url = "jdbc:sqlite:movies.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ACTORS LIMIT 1;");
            rs.close();
        } catch(Exception e) {
        }
    }
}
