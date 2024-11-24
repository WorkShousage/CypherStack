package dao;

import models.File;
import utils.DatabaseHelper;

import java.sql.*;

public class FileDAO {

    // Retrieve a file by ID
    public File getFileById(int fileId) throws SQLException {
        String query = "SELECT * FROM files WHERE file_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, fileId);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return new File(
                    resultSet.getInt("file_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getString("file_name"),
                    resultSet.getInt("file_size"),
                    resultSet.getBytes("encryption_key"),
                    resultSet.getTimestamp("upload_date").toLocalDateTime(),
                    resultSet.getBoolean("is_encrypted")
                );
            }
        }
        return null; // File not found
    }

    // Additional CRUD methods (Create, Update, Delete) for files can be implemented here
}
