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
    private Label statusLabel; // Label to show status messages (optional)

    // Initialize method to set up initial state
    @FXML
    public void initialize() {
        // You can set up any initial state here if needed
    }

    // Event handler for the SIGN IN button
    @FXML
    private void handleSignInButton() {
        String email = emailField.getText();
        String password = passwordField.getText();

        // Logic for sign-in (e.g., validate credentials)
        if (validateCredentials(email, password)) {
            // Proceed to the next screen or show success message
            System.out.println("Sign-in successful!");
            // Add logic to navigate to the next screen
        } else {
            // Show error message
            System.out.println("Invalid email or password.");
            // Optionally update statusLabel to show an error message
        }
    }

    // Event handler for the Forgot Password hyperlink
    @FXML
    private void handleForgotPassword() {
        System.out.println("Forgot password clicked!");
        // Logic to handle password recovery
    }

    // Event handler for the Create Account hyperlink
    @FXML
    private void handleCreateAccount() {
        System.out.println("Create Account clicked!");
        // Logic to navigate to the account creation screen
    }

    // Method to validate user credentials (dummy implementation)
    private boolean validateCredentials(String email, String password) {
        // Replace this with actual validation logic (e.g., check against a database)
        return email.equals("test@example.com") && password.equals("password123");
    }
}
