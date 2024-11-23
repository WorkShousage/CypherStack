import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;

public class FileEncryptorBackend {

    // Method to encrypt a file given the file path and encryption key
    public void encryptFile(Path filePath, String keyString) throws Exception {
        byte[] fileContent = Files.readAllBytes(filePath);  // Read file contents
        SecretKey secretKey = generateKey(keyString);       // Generate encryption key
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedContent = cipher.doFinal(fileContent);  // Encrypt file content

        // Overwrite the original file with encrypted content
        Files.write(filePath, encryptedContent);
    }

    // Method to decrypt a file given the file path and decryption key
    public void decryptFile(Path encryptedFilePath, String keyString) throws Exception {
        SecretKey secretKey = generateKey(keyString);  // Generate decryption key
        byte[] encryptedContent = Files.readAllBytes(encryptedFilePath); // Read file content
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedContent = cipher.doFinal(encryptedContent);  // Decrypt file content

        // Overwrite the encrypted file with decrypted content
        Files.write(encryptedFilePath, decryptedContent);
    }

    // Helper method to generate a SecretKey from a string (key)
    private SecretKey generateKey(String key) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Create SHA-256 hash of key
        byte[] keyBytes = digest.digest(key.getBytes("UTF-8"));      // Get key bytes
        return new SecretKeySpec(keyBytes, "AES");                   // Create AES key
    }
}

