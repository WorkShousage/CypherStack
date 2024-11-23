package com.cypherstack.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
        // Example: Attach event handlers to buttons
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
        // Add navigation logic here
    }

    private void navigateToProfile() {
        System.out.println("Navigating to Profile...");
        // Add navigation logic here
    }

    private void navigateToFileManagement() {
        System.out.println("Navigating to File Management...");
        // Add navigation logic here
    }

    private void navigateToBackupRestore() {
        System.out.println("Navigating to Backup & Restore...");
        // Add navigation logic here
    }

    private void navigateToIntruderActivity() {
        System.out.println("Navigating to Intruder Activity...");
        // Add navigation logic here
    }

    private void handleAddNew() {
        System.out.println("Add New clicked...");
        // Add logic to handle 'Add New' button click
    }
}
