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
    private int encryptionKeyId;
    private LocalDateTime decryptedAt;
    private String cloudPath;

    // Getters and Setters
    // ...
}
