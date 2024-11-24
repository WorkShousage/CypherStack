package dao;

import models.EncryptionKey;
import utils.DatabaseHelper;

import java.sql.*;

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

    // Methods for inserting, updating, and deleting encryption keys can be added here
}
