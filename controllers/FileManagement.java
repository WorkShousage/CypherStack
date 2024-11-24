import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
        try {
    // Load the dashboard FXML file
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml")); // Replace with your actual FXML file name
    Parent dashboardView = loader.load();

    // Get the current stage (window)
    Stage currentStage = (Stage) dashboardButton.getScene().getWindow();

    // Set the new scene
    currentStage.setScene(new Scene(dashboardView));
    currentStage.show();
} catch (Exception e) {
    e.printStackTrace(); // Handle any exceptions that occur during loading
}
    }

    // Event handler for Profile button
    @FXML
    private void handleProfileButton() {
        System.out.println("Profile button clicked!");
      try {
    // Load the profile FXML file
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml")); // Replace with your actual FXML file name
    Parent profileView = loader.load();

    // Get the current stage (window)
    Stage currentStage = (Stage) profileButton.getScene().getWindow();

    // Set the new scene
    currentStage.setScene(new Scene(profileView));
    currentStage.show();
} catch (Exception e) {
    e.printStackTrace(); // Handle any exceptions that occur during loading
}
    }

    // Event handler for File Management button
    @FXML
    private void handleFileManagementButton() {
        System.out.println("File Management button clicked!");
        // Logic to manage files
    }

    // Event handler for Backup & Restore button
    @FXML
    private void handleBackupRestoreButton() {
        System.out.println("Backup & Restore button clicked!");
        // Logic for backup and restore
    }

    // Event handler for Intruder Activity button
    @FXML
    private void handleIntruderActivityButton() {
        System.out.println("Intruder Activity button clicked!");
        // Logic to view intruder activity
    }

    // Event handler for Add New button
    @FXML
    private void handleAddNewButton() {
        System.out.println("+ Add New button clicked!");
        // Logic to add new records
    }

    // Search functionality
    @FXML
    private void handleSearch() {
        String query = searchField.getText();
        System.out.println("Searching for: " + query);
        // Logic to perform search
    }
}
