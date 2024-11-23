package models;

import java.time.LocalDateTime;

public class ModelUtils {

    // Validate if a string is not null or empty
    public static boolean isValidString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // Format timestamp to a readable string
    public static String formatTimestamp(LocalDateTime timestamp) {
        return timestamp != null ? timestamp.toString() : "N/A";
    }
}
