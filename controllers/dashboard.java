package com.cypherstack.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    @FXML
    private TextField searchField; // Search TextField
    @FXML
    private Button dashboardButton; // Dashboard button
    @FXML
    private Button profileButton; // Profile button
    @FXML
    private Button fileManagementButton; // File management button
    @FXML
    private Button backupRestoreButton; // Backup & Restore button
    @FXML
    private Button intruderActivityButton; // Intruder Activity button
    @FXML
    private Button addNewButton; // Add New button
    @FXML
    private Label userEmailLabel; // Label to show user email
    @FXML
    private ProgressBar securityScoreBar; // Progress bar for security score
    @FXML
    private Label passwordStrengthLabel; // Label for password strength
    @FXML
    private Label uniqueRecordPasswordsLabel; // Label for unique record passwords
    @FXML
    private Label twoFactorAuthLabel; // Label for two-factor authentication

    // Initialize method to set up initial state
    @FXML
    public void initialize() {
        // Example initialization logic
        userEmailLabel.setText("newuser123@gmail.com");
        securityScoreBar.setProgress(0.9); // Example score
        passwordStrengthLabel.setText("88%");
        uniqueRecordPasswordsLabel.setText("98%");
        twoFactorAuthLabel.setText("50%");
    }

    // Event handler for Dashboard button
    @FXML
    private void handleDashboardButton() {
        System.out.println("Dashboard button clicked!");
        navigateTo("/com/cypherstack/views/dashboard.fxml");
    }

    // Event handler for Profile button
    @FXML
    private void handleProfileButton() {
        System.out.println("Profile button clicked!");
        navigateTo("/com/cypherstack/views/profile.fxml");
    }

    // Event handler for File Management button
    @FXML
    private void handleFileManagementButton() {
        System.out.println("File Management button clicked!");
        navigateTo("/com/cypherstack/views/file_management.fxml");
    }

    // Event handler for Backup & Restore button
    @FXML
    private void handleBackupRestoreButton() {
        System.out.println("Backup & Restore button clicked!");
        navigateTo("/com/cypherstack/views/backup_restore.fxml");
    }

    // Event handler for Intruder Activity button
    @FXML
    private void handleIntruderActivityButton() {
        System.out.println("Intruder Activity button clicked!");
        navigateTo("/com/cypherstack/views/intruder_activity.fxml");
    }

    // Event handler for Add New button
    @FXML
    private void handleAddNewButton() {
        System.out.println("+ Add New button clicked!");
        // Logic to open a dialog or new window for adding new records
        openAddNewDialog();
    }

    // Search functionality
    @FXML
    private void handleSearch() {
        String query = searchField.getText();
        System.out.println("Searching for: " + query);
        // Logic to perform search
        performSearch(query);
    }

    // Method to handle navigation
    private void navigateTo(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage currentStage = (Stage) dashboardButton.getScene().getWindow(); // You can use any button here to get the current stage
            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, show an error message to the user
        }
    }

    // Method to open a dialog for adding new records
    private void openAddNewDialog() {
        // Here you can create a new window or dialog for adding new records
        // For example, you can load another FXML file for the add new record view
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cypherstack/views/add_new.fxml")); // Update with your actual FXML path
            Parent addNewRoot = loader.load();
            Stage addNewStage = new Stage();
            addNewStage.setTitle("Add New Record");
            addNewStage.setScene(new Scene(addNewRoot));
            addNewStage.show();
        } catch (IOException e) {
            e.printStackTrace();
