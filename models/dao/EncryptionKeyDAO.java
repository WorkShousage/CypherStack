package dao;

import models.EncryptionKey;
import utils.DatabaseHelper;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EncryptionKeyDAO {

    // Retrieve encryption key by user ID
    public EncryptionKey getKeyByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM encryption_keys WHERE user_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return new EncryptionKey(
                    resultSet.getInt("key_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getBytes("public_key"),
                    resultSet.getBytes("private_key"),
                    resultSet.getBytes("aes_key"),
                    resultSet.getTimestamp("created_at").toLocalDateTime()
                );
            }
        }
        return null; // Encryption key not found
    }

    // Create a new encryption key record
    public boolean createEncryptionKey(EncryptionKey key) throws SQLException {
        String query = "INSERT INTO encryption_keys (user_id, public_key, private_key, aes_key, created_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, key.getUserId());
            statement.setBytes(2, key.getPublicKey());
            statement.setBytes(3, key.getPrivateKey());
            statement.setBytes(4, key.getAesKey());
            statement.setTimestamp(5, Timestamp.valueOf(key.getCreatedAt()));

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    // Update an existing encryption key record
    public boolean updateEncryptionKey(EncryptionKey key) throws SQLException {
        String query = "UPDATE encryption_keys SET public_key = ?, private_key = ?, aes_key = ?, created_at = ? WHERE key_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setBytes(1, key.getPublicKey());
            statement.setBytes(2, key.getPrivateKey());
            statement.setBytes(3, key.getAesKey());
            statement.setTimestamp(4, Timestamp.valueOf(key.getCreatedAt()));
            statement.setInt(5, key.getKeyId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    // Delete an encryption key by ID
    public boolean deleteEncryptionKey(int keyId) throws SQLException {
        String query = "DELETE FROM encryption_keys WHERE key_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, keyId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }

    // Retrieve all encryption keys for a specific user (Optional but useful)
    public List<EncryptionKey> getAllKeysByUserId(int userId) throws SQLException {
        List<EncryptionKey> keys = new ArrayList<>();
        String query = "SELECT * FROM encryption_keys WHERE user_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                EncryptionKey key = new EncryptionKey(
                    resultSet.getInt("key_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getBytes("public_key"),
                    resultSet.getBytes("private_key"),
                    resultSet.getBytes("aes_key"),
                    resultSet.getTimestamp("created_at").toLocalDateTime()
                );
                keys.add(key);
            }
        }
        return keys;
    }
}
