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

    // Getters and Setters
    // ...
}
