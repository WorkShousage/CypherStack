package dao;

import models.ActivityLog;
import utils.DatabaseHelper;

import java.sql.*;

public class ActivityLogDAO {

    // Retrieve activity log by user ID
    public ActivityLog getLogByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM activity_logs WHERE user_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return new ActivityLog(
                    resultSet.getInt("log_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getString("action_type"),
                    resultSet.getTimestamp("timestamp").toLocalDateTime(),
                    resultSet.getString("status")
                );
            }
        }
        return null; // Activity log not found
    }

    // Methods for adding, updating, and deleting activity logs
}
