package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/cypherstack"; // Replace with your database URL
    private static final String USER = "root"; // Replace with your database username
    private static final String PASSWORD = "password"; // Replace with your database password

    // Load the JDBC driver and establish a connection
    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            throw new SQLException("Driver not found", e);
        }

        // Establish and return the connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Test the connection (Optional for debugging)
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Database connection successful!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}
