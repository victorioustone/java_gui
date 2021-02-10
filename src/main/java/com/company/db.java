package com.company;

import java.sql.*;

public class db {

    public int Connect(String LOGIN, String PASSWORD) throws SQLException {
        String URL = "jdbc:postgresql://127.0.0.1:5432/rubber_duck_db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Database was connected");
            return 0;
        } catch (SQLException sqlException) {
            System.out.println("Connection failed");
            sqlException.printStackTrace();
            return 1;
        }
    }
}
