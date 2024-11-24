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

    // Constructor to initialize the AuditLog
    public AuditLog(User user, File file, ActionType actionType, String description) {
        this.user = user;
        this.file = file;
        this.actionType = actionType;
        this.actionTime = LocalDateTime.now();  // Automatically set the action time to current time
        this.description = description;
    }

    // Method to create an audit log entry (you can call this from a service or controller layer)
    public static AuditLog createAuditLog(User user, File file, ActionType actionType, String description) {
        return new AuditLog(user, file, actionType, description);
    }

    // Getters and Setters
    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
