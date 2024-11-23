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

    // Getters and Setters
    // ...
}
