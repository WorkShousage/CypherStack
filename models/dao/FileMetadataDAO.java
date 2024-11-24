package dao;

import models.FileMetadata;
import utils.DatabaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                    resultSet.getTimestamp("decrypted_at") != null ? resultSet.getTimestamp("decrypted_at").toLocalDateTime() : null,
                    resultSet.getString("cloud_path")
                );
            }
        }
        return null; // Metadata not found
    }

    // Create new file metadata
    public boolean createFileMetadata(FileMetadata metadata) throws SQLException {
        String query = "INSERT INTO file_metadata (file_id, encryption_method, encryption_key_id, decrypted_at, cloud_path) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, metadata.getFileId());
            statement.setString(2, metadata.getEncryptionMethod());
            statement.setInt(3, metadata.getEncryptionKeyId());
            statement.setTimestamp(4, metadata.getDecryptedAt() != null ? Timestamp.valueOf(metadata.getDecryptedAt()) : null);
            statement.setString(5, metadata.getCloudPath());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    // Update existing file metadata
    public boolean updateFileMetadata(FileMetadata metadata) throws SQLException {
        String query = "UPDATE file_metadata SET encryption_method = ?, encryption_key_id = ?, decrypted_at = ?, cloud_path = ? WHERE metadata_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, metadata.getEncryptionMethod());
            statement.setInt(2, metadata.getEncryptionKeyId());
            statement.setTimestamp(3, metadata.getDecryptedAt() != null ? Timestamp.valueOf(metadata.getDecryptedAt()) : null);
            statement.setString(4, metadata.getCloudPath());
            statement.setInt(5, metadata.getMetadataId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    // Delete file metadata by ID
    public boolean deleteFileMetadata(int metadataId) throws SQLException {
        String query = "DELETE FROM file_metadata WHERE metadata_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, metadataId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }

    // Retrieve all file metadata (Optional but useful)
    public List<FileMetadata> getAllFileMetadata() throws SQLException {
        List<FileMetadata> metadataList = new ArrayList<>();
        String query = "SELECT * FROM file_metadata";
        try (Connection connection = DatabaseHelper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                FileMetadata metadata = new FileMetadata(
                    resultSet.getInt("metadata_id"),
                    resultSet.getInt("file_id"),
                    resultSet.getString("encryption_method"),
                    resultSet.getInt("encryption_key_id"),
                    resultSet.getTimestamp("decrypted_at") != null ? resultSet.getTimestamp("decrypted_at").toLocalDateTime() : null,
                    resultSet.getString("cloud_path")
                );
                metadataList.add(metadata);
            }
        }
        return metadataList;
    }
}
