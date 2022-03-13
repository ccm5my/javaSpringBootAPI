package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionFactory {

    private static Connection conn = null;
    
    static {
        try {
            String url = "jdbc:sqlite:movies.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (Exception e) {
            System.out.println("Connection failed!");
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}

