package models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    private LocalDateTime timestamp;
    private String status;

    public enum ActionType {
        LOGIN, UPLOAD, DOWNLOAD, ENCRYPT, DECRYPT
    }

    // Getters and Setters
    // ...
}
