package com.company;

import java.sql.*;

public class db {

    public int Connect(String LOGIN, String PASSWORD){
        String URL = "jdbc:postgresql://127.0.0.1:5432/rubber_duck_db";
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Database was connected");
            Statement statement;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM duckee");
                while (resultSet.next()) {
                    System.out.print(resultSet.getString(1) + "  ");
                    System.out.print(resultSet.getString(2) + "  ");
                    System.out.print(resultSet.getString(3) + "  ");
                    System.out.print(resultSet.getString(4) + "  ");
                    System.out.println();
                }
            } catch (SQLException e){
                System.out.println("query failed");
            }
            return 0;
        } catch (SQLException sqlException) {
            System.out.println("Connection failed");
            sqlException.printStackTrace();
            return 1;
        }
    }
}
