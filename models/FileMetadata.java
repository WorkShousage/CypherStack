package models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "file_metadata")
public class FileMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int metadataId;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private File file;

    private String encryptionMethod;

    // Relationship with the EncryptionKey model instead of just an encryptionKeyId field
    @ManyToOne
    @JoinColumn(name = "encryption_key_id")
    private EncryptionKey encryptionKey;

    private LocalDateTime decryptedAt;
    private String cloudPath;

    // Constructor to initialize FileMetadata object
    public FileMetadata(File file, String encryptionMethod, EncryptionKey encryptionKey, String cloudPath) {
        this.file = file;
        this.encryptionMethod = encryptionMethod;
        this.encryptionKey = encryptionKey;
        this.decryptedAt = null;  // Set null initially; update when file is decrypted
        this.cloudPath = cloudPath;
    }

    // Method to create FileMetadata entry (you can use this from a service layer)
    public static FileMetadata createFileMetadata(File file, String encryptionMethod, EncryptionKey encryptionKey, String cloudPath) {
        return new FileMetadata(file, encryptionMethod, encryptionKey, cloudPath);
    }

    // Getters and Setters
    public int getMetadataId() {
        return metadataId;
    }

    public void setMetadataId(int metadataId) {
        this.metadataId = metadataId;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getEncryptionMethod() {
        return encryptionMethod;
    }

    public void setEncryptionMethod(String encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
    }

    public EncryptionKey getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(EncryptionKey encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public LocalDateTime getDecryptedAt() {
        return decryptedAt;
    }

    public void setDecryptedAt(LocalDateTime decryptedAt) {
        this.decryptedAt = decryptedAt;
    }

    public String getCloudPath() {
        return cloudPath;
    }

    public void setCloudPath(String cloudPath) {
        this.cloudPath = cloudPath;
    }
}
