package models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {

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

    // Constructor to initialize the ActivityLog
    public ActivityLog(User user, ActionType actionType, String status) {
        this.user = user;
        this.actionType = actionType;
        this.timestamp = LocalDateTime.now();  // Automatically set the timestamp to current time
        this.status = status;
    }

    // Method to create a log entry (you can call this from a service or controller layer)
    public static ActivityLog createLog(User user, ActionType actionType, String status) {
        return new ActivityLog(user, actionType, status);
    }

    // Getters and Setters
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
