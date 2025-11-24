package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                "root",
                "yearup"
        );

        Statement statement = connection.createStatement();

        String read = """
                SELECT ProductName\s
                FROM northwind.products;
                """;

        ResultSet lines = statement.executeQuery(read);

        while (lines.next()){
            String productName = lines.getString(1);
            System.out.println(productName);
        }
        connection.close();
    }
}
