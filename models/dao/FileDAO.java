package dao;

import models.File;
import utils.DatabaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    // Create a new file record
    public boolean createFile(File file) throws SQLException {
        String query = "INSERT INTO files (user_id, file_name, file_size, encryption_key, upload_date, is_encrypted) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, file.getUserId());
            statement.setString(2, file.getFileName());
            statement.setInt(3, file.getFileSize());
            statement.setBytes(4, file.getEncryptionKey());
            statement.setTimestamp(5, Timestamp.valueOf(file.getUploadDate()));
            statement.setBoolean(6, file.isEncrypted());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    // Update an existing file record
    public boolean updateFile(File file) throws SQLException {
        String query = "UPDATE files SET file_name = ?, file_size = ?, encryption_key = ?, upload_date = ?, is_encrypted = ? WHERE file_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, file.getFileName());
            statement.setInt(2, file.getFileSize());
            statement.setBytes(3, file.getEncryptionKey());
            statement.setTimestamp(4, Timestamp.valueOf(file.getUploadDate()));
            statement.setBoolean(5, file.isEncrypted());
            statement.setInt(6, file.getFileId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    // Delete a file record by ID
    public boolean deleteFile(int fileId) throws SQLException {
        String query = "DELETE FROM files WHERE file_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, fileId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }

    // Retrieve all files for a specific user (Optional but useful)
    public List<File> getFilesByUserId(int userId) throws SQLException {
        List<File> files = new ArrayList<>();
        String query = "SELECT * FROM files WHERE user_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                File file = new File(
                    resultSet.getInt("file_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getString("file_name"),
                    resultSet.getInt("file_size"),
                    resultSet.getBytes("encryption_key"),
                    resultSet.getTimestamp("upload_date").toLocalDateTime(),
                    resultSet.getBoolean("is_encrypted")
                );
                files.add(file);
            }
        }
        return files;
    }
}
