package models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auditId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private File file;

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    private LocalDateTime actionTime;
    private String description;

    public enum ActionType {
        ENCRYPT, DECRYPT
    }

    // Getters and Setters
    // ...
}
