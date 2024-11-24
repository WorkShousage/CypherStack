package dao;

import models.ActivityLog;
import utils.DatabaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    // Create a new activity log
    public boolean createActivityLog(ActivityLog log) throws SQLException {
        String query = "INSERT INTO activity_logs (user_id, action_type, timestamp, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, log.getUserId());
            statement.setString(2, log.getActionType());
            statement.setTimestamp(3, Timestamp.valueOf(log.getTimestamp()));
            statement.setString(4, log.getStatus());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    // Update an existing activity log
    public boolean updateActivityLog(ActivityLog log) throws SQLException {
        String query = "UPDATE activity_logs SET action_type = ?, timestamp = ?, status = ? WHERE log_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, log.getActionType());
            statement.setTimestamp(2, Timestamp.valueOf(log.getTimestamp()));
            statement.setString(3, log.getStatus());
            statement.setInt(4, log.getLogId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    // Delete an activity log by ID
    public boolean deleteActivityLog(int logId) throws SQLException {
        String query = "DELETE FROM activity_logs WHERE log_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, logId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }

    // Retrieve all activity logs for a specific user (Optional but useful)
    public List<ActivityLog> getAllLogsByUserId(int userId) throws SQLException {
        List<ActivityLog> logs = new ArrayList<>();
        String query = "SELECT * FROM activity_logs WHERE user_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ActivityLog log = new ActivityLog(
                    resultSet.getInt("log_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getString("action_type"),
                    resultSet.getTimestamp("timestamp").toLocalDateTime(),
                    resultSet.getString("status")
                );
                logs.add(log);
            }
        }
        return logs;
    }
}
