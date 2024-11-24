import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {

    @FXML
    private TextField emailField; // TextField for email input
    @FXML
    private PasswordField passwordField; // PasswordField for password input
    @FXML
    private Button signInButton; // Button to trigger sign-in
    @FXML
    private Hyperlink forgotPasswordLink; // Hyperlink for forgot password
    @FXML
    private Hyperlink createAccountLink; // Hyperlink to create a new account
    @FXML
    private Label statusLabel; // Label to show status messages

    // Initialize method to set up initial state
    @FXML
    public void initialize() {
        statusLabel.setText(""); // Clear status label on initialization
    }

    // Event handler for the SIGN IN button
    @FXML
    private void handleSignInButton() {
        String email = emailField.getText().trim();
        String password = passwordField.getText();

        // Basic input validation
        if (email.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Email and password cannot be empty.");
            return;
        }

if (validateCredentials(email, password)) {
    statusLabel.setText("Sign-in successful!");
    
    // Add logic to navigate to the next screen
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml")); // Replace with your actual FXML file name
        Parent dashboardView = loader.load();

        // Get the current stage (window)
        Stage currentStage = (Stage) signInButton.getScene().getWindow();

        // Set the new scene
        currentStage.setScene(new Scene(dashboardView));
        currentStage.show();
    } catch (Exception e) {
        e.printStackTrace(); // Handle any exceptions that occur during loading
    }
} else {
    statusLabel.setText("Invalid email or password.");
}
        if (validateCredentials(email, password)) {
            statusLabel.setText("Sign-in successful!");
            // Add logic to navigate to the next screen
        } else {
            statusLabel.setText("Invalid email or password.");
        }

        // Clear fields after submission
        emailField.clear();
        passwordField.clear();
    }

    // Event handler for the Forgot Password hyperlink
    @FXML
    private void handleForgotPassword() {
        System.out.println("Forgot password clicked!");

try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("PasswordRecovery.fxml")); // Replace with your actual FXML file name
    Parent recoveryView = loader.load();

    // Get the current stage (window)
    Stage currentStage = (Stage) forgotPasswordLink.getScene().getWindow();

    // Set the new scene
    currentStage.setScene(new Scene(recoveryView));
    currentStage.show();
} catch (Exception e) {
    e.printStackTrace(); // Handle any exceptions that occur during loading
}
    }

    // Event handler for the Create Account hyperlink
    @FXML
    private void handleCreateAccount() {
        System.out.println("Create Account clicked!");
      
try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateAccount.fxml")); // Replace with your actual FXML file name
    Parent createAccountView = loader.load();

    // Get the current stage (window)
    Stage currentStage = (Stage) createAccountLink.getScene().getWindow();

    // Set the new scene
    currentStage.setScene(new Scene(createAccountView));
    currentStage.show();
} catch (Exception e) {
    e.printStackTrace(); // Handle any exceptions that occur during loading
}
    }

    // Method to validate user credentials (dummy implementation)
    private boolean validateCredentials(String email, String password) {
        // Replace this with actual validation logic (e.g., check against a database)
        return email.equals("test@example.com") && password.equals("password123");
    }
}
