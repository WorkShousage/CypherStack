package dao;

import models.AuditLog;
import utils.DatabaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuditLogDAO {

    // Retrieve audit log by file ID
    public AuditLog getLogByFileId(int fileId) throws SQLException {
        String query = "SELECT * FROM audit_logs WHERE file_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, fileId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new AuditLog(
                    resultSet.getInt("audit_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getInt("file_id"),
                    resultSet.getString("action_type"),
                    resultSet.getTimestamp("action_time").toLocalDateTime(),
                    resultSet.getString("description")
                );
            }
        }
        return null; // Audit log not found
    }

    // Create a new audit log entry
    public boolean createAuditLog(AuditLog log) throws SQLException {
        String query = "INSERT INTO audit_logs (user_id, file_id, action_type, action_time, description) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, log.getUserId());
            statement.setInt(2, log.getFileId());
            statement.setString(3, log.getActionType());
            statement.setTimestamp(4, Timestamp.valueOf(log.getActionTime()));
            statement.setString(5, log.getDescription());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    // Update an existing audit log entry
    public boolean updateAuditLog(AuditLog log) throws SQLException {
        String query = "UPDATE audit_logs SET user_id = ?, file_id = ?, action_type = ?, action_time = ?, description = ? WHERE audit_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, log.getUserId());
            statement.setInt(2, log.getFileId());
            statement.setString(3, log.getActionType());
            statement.setTimestamp(4, Timestamp.valueOf(log.getActionTime()));
            statement.setString(5, log.getDescription());
            statement.setInt(6, log.getAuditId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    // Delete an audit log entry by ID
    public boolean deleteAuditLog(int auditId) throws SQLException {
        String query = "DELETE FROM audit_logs WHERE audit_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, auditId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }

    // Retrieve all audit logs for a specific file (Optional but useful)
    public List<AuditLog> getAllLogsByFileId(int fileId) throws SQLException {
        List<AuditLog> logs = new ArrayList<>();
        String query = "SELECT * FROM audit_logs WHERE file_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, fileId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                AuditLog log = new AuditLog(
                    resultSet.getInt("audit_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getInt("file_id"),
                    resultSet.getString("action_type"),
                    resultSet.getTimestamp("action_time").toLocalDateTime(),
                    resultSet.getString("description")
                );
                logs.add(log);
            }
        }
        return logs;
    }
}
