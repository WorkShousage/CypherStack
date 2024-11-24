package models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "encryption_keys")
public class EncryptionKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int keyId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Lob
    private byte[] publicKey;

    @Lob
    private byte[] privateKey;

    @Lob
    private byte[] aesKey;

    private LocalDateTime createdAt;

    // Constructor to initialize the EncryptionKey
    public EncryptionKey(User user, byte[] publicKey, byte[] privateKey, byte[] aesKey) {
        this.user = user;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.aesKey = aesKey;
        this.createdAt = LocalDateTime.now();  // Automatically set the creation time to current time
    }

    // Method to create an EncryptionKey (you can use this from a service layer)
    public static EncryptionKey createEncryptionKey(User user, byte[] publicKey, byte[] privateKey, byte[] aesKey) {
        return new EncryptionKey(user, publicKey, privateKey, aesKey);
    }

    // Getters and Setters
    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
    }

    public byte[] getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(byte[] privateKey) {
        this.privateKey = privateKey;
    }

    public byte[] getAesKey() {
        return aesKey;
    }

    public void setAesKey(byte[] aesKey) {
        this.aesKey = aesKey;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
