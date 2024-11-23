package com.cypherstack.main;

public class UserSession {

    private static UserSession instance;
    private String username;
    private String role;  // Could be 'manager', 'employee', etc.
    private boolean isAuthenticated;

    // Private constructor to prevent instantiation
    private UserSession() {
        this.isAuthenticated = false;  // Initially not authenticated
    }

    /**
     * Returns the single instance of UserSession (Singleton pattern).
     * 
     * @return the current instance of UserSession
     */
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    /**
     * Starts a new user session.
     * 
     * @param username The username of the logged-in user.
     * @param role The role of the user (e.g., 'manager', 'employee').
     */
    public void startSession(String username, String role) {
        this.username = username;
        this.role = role;
        this.isAuthenticated = true;
    }

    /**
     * Ends the current user session.
     */
    public void endSession() {
        this.username = null;
        this.role = null;
        this.isAuthenticated = false;
    }

    /**
     * Returns whether the user is authenticated.
     * 
     * @return true if the user is authenticated, false otherwise.
     */
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    /**
     * Returns the username of the logged-in user.
     * 
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the role of the logged-in user.
     * 
     * @return the role ('manager', 'employee', etc.).
     */
    public String getRole() {
        return role;
    }

    /**
     * Checks if the user has a manager role.
     * 
     * @return true if the user is a manager, false otherwise.
     */
    public boolean isManager() {
        return "manager".equals(role);
    }

    /**
     * Checks if the user has an employee role.
     * 
     * @return true if the user is an employee, false otherwise.
     */
    public boolean isEmployee() {
        return "employee".equals(role);
    }
}
