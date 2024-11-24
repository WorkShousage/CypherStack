package dao;

import models.User;
import utils.DatabaseHelper;

import java.sql.*;

public class UserDAO {

    // Retrieve user by username
    public User getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("role")
                );
            }
        }
        return null; // User not found
    }

    // Other CRUD methods (Create, Update, Delete) can be implemented similarly
}
