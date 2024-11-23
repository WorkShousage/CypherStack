package dao;

import models.AuditLog;
import utils.DatabaseHelper;

import java.sql.*;

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

    // Additional methods for inserting, updating, and deleting audit logs
}
