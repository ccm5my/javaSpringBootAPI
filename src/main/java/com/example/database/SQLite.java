package com.example.database;

import com.example.spec.ISQLite;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class SQLite implements ISQLite {

    public void testCanConnect() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // db parameters (assumes movies.db is in the same directory)
            String url = "jdbc:sqlite:movies.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

            // Ensure we can query the actors table
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ACTORS LIMIT 1;");

            while ( rs.next() ) {

                String  name = rs.getString("name");

                System.out.println(String.format("Found %s", name));
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
