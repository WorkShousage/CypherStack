package com.cypherstack.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    // Sidebar Buttons
    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnFileManagement;

    @FXML
    private Button btnBackupRestore;

    @FXML
    private Button btnIntruderActivity;

    @FXML
    private Button btnAddNew;

    // Top Bar Elements
    @FXML
    private TextField searchField;

    @FXML
    private ImageView profileIcon;

    @FXML
    private Label userEmailLabel;

    // Bottom Bar Elements
    @FXML
    private ImageView settingsIcon;

    @FXML
    private Label settingsLabel;

    // Initialize method for setting up event handlers
    @FXML
    public void initialize() {
        // Attach event handlers to buttons
        btnDashboard.setOnAction(event -> navigateToDashboard());
        btnProfile.setOnAction(event -> navigateToProfile());
        btnFileManagement.setOnAction(event -> navigateToFileManagement());
        btnBackupRestore.setOnAction(event -> navigateToBackupRestore());
        btnIntruderActivity.setOnAction(event -> navigateToIntruderActivity());
        btnAddNew.setOnAction(event -> handleAddNew());
    }

    // Navigation Methods
    private void navigateToDashboard() {
        System.out.println("Navigating to Dashboard...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cypherstack/views/dashboard.fxml")); // Update with your actual FXML path
            Parent dashboardRoot = loader.load();
            Stage currentStage = (Stage) btnDashboard.getScene().getWindow();
            currentStage.setScene(new Scene(dashboardRoot));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, show an error message to the user
        }
    }

    private void navigateToProfile() {
        System.out.println("Navigating to Profile...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cypherstack/views/profile.fxml")); // Update with your actual FXML path
            Parent profileRoot = loader.load();
            Stage currentStage = (Stage) btnProfile.getScene().getWindow();
            currentStage.setScene(new Scene(profileRoot));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, show an error message to the user
        }
    }

    private void navigateToFileManagement() {
        System.out.println("Navigating to File Management...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cypherstack/views/file_management.fxml")); // Update with your actual FXML path
            Parent fileManagementRoot = loader.load();
            Stage currentStage = (Stage) btnFileManagement.getScene().getWindow();
            currentStage.setScene(new Scene(fileManagementRoot));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, show an error message to the user
        }
    }

    private void navigateToBackupRestore() {
        System.out.println("Navigating to Backup & Restore...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cypherstack/views/backup_restore.fxml")); // Update with your actual FXML path
            Parent backupRestoreRoot = loader.load();
            Stage currentStage = (Stage) btnBackupRestore.getScene().getWindow();
            currentStage.setScene(new Scene(backupRestoreRoot));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, show an error message to the user
        }
    }

    private void navigateToIntruderActivity() {
        System.out.println("Navigating to Intruder Activity...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cypherstack/views/intruder_activity.fxml")); // Update with your actual FXML path
            Parent intruderActivityRoot = loader.load();
            Stage currentStage = (Stage) btnIntruderActivity.getScene().getWindow();
            currentStage.setScene(new Scene(intruderActivityRoot));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, show an error message to the user
        }
    }

    private void handleAdd
