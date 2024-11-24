package dao;

import models.FileMetadata;
import utils.DatabaseHelper;

import java.sql.*;

public class FileMetadataDAO {

    // Retrieve metadata by file ID
    public FileMetadata getMetadataByFileId(int fileId) throws SQLException {
        String query = "SELECT * FROM file_metadata WHERE file_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, fileId);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return new FileMetadata(
                    resultSet.getInt("metadata_id"),
                    resultSet.getInt("file_id"),
                    resultSet.getString("encryption_method"),
                    resultSet.getInt("encryption_key_id"),
                    resultSet.getTimestamp("decrypted_at").toLocalDateTime(),
                    resultSet.getString("cloud_path")
                );
            }
        }
        return null; // Metadata not found
    }

    // Additional methods for managing metadata (Create, Update, Delete)
}
