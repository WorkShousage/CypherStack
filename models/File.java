package models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fileId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String fileName;
    private int fileSize;

    @Lob
    private byte[] encryptionKey;

    private LocalDateTime uploadDate;
    private boolean isEncrypted;

    // Constructor to initialize the File object
    public File(User user, String fileName, int fileSize, byte[] encryptionKey, boolean isEncrypted) {
        this.user = user;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.encryptionKey = encryptionKey;
        this.uploadDate = LocalDateTime.now();  // Automatically set the upload date to the current time
        this.isEncrypted = isEncrypted;
    }

    // Method to create a File entry (you can use this in a service layer)
    public static File createFile(User user, String fileName, int fileSize, byte[] encryptionKey, boolean isEncrypted) {
        return new File(user, fileName, fileSize, encryptionKey, isEncrypted);
    }

    // Getters and Setters
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(byte[] encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public boolean isEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }
}
