package com.employees.employeemanagement.dbconnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateDatabaseConnection {

    private static Connection connection;

    public static Connection createConnection() {
        Properties properties = new Properties();
        InputStream stream = CreateDatabaseConnection.class
                .getClassLoader()
                .getResourceAsStream("db.properties");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            properties.load(stream);
            CreateDatabaseConnection.connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/emp-management",
                            properties);
        } catch (ClassNotFoundException | IOException | SQLException e) {
            e.printStackTrace();
        }
        return CreateDatabaseConnection.connection;
    }
}
