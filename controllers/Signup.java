import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private TextField firstNameField; // TextField for first name input
    @FXML
    private TextField lastNameField; // TextField for last name input
    @FXML
    private ComboBox<String> roleComboBox; // ComboBox for user role
    @FXML
    private ComboBox<String> countryCodeComboBox; // ComboBox for country code
    @FXML
    private PasswordField contactNoField; // PasswordField for contact number
    @FXML
    private Button signUpButton; // Button to trigger sign-up
    @FXML
    private Hyperlink loginLink; // Hyperlink to log in
    @FXML
    private Label statusLabel; // Optional label for status messages

    // Initialize method to set up initial state
    @FXML
    public void initialize() {
        // Populate roleComboBox with roles
        roleComboBox.getItems().addAll("Admin", "User ", "Manager"); // Example roles
        countryCodeComboBox.getItems().addAll("+91", "+1", "+44"); // Example country codes

        // Clear status label on initialization
        statusLabel.setText("");
    }

    // Event handler for the SIGN UP button
    @FXML
    private void handleSignUpButton() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String role = roleComboBox.getValue();
        String contactNo = contactNoField.getText().trim();

        // Basic validation
        if (firstName.isEmpty() || lastName.isEmpty() || role == null || contactNo.isEmpty()) {
            statusLabel.setText("Please fill in all fields.");
            return;
        }

       
String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // Update with your database URL
String dbUser   = "your_username"; // Update with your database username
String dbPassword = "your_password"; // Update with your database password

String insertSQL = "INSERT INTO users (first_name, last_name, role, contact_no) VALUES (?, ?, ?, ?)";

try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser , dbPassword);
     PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
     
    preparedStatement.setString(1, firstName);
    preparedStatement.setString(2, lastName);
    preparedStatement.setString(3, role);
    preparedStatement.setString(4, contactNo);
    
    int rowsAffected = preparedStatement.executeUpdate();
    
    if (rowsAffected > 0) {
        statusLabel.setText("Sign up successful!");
    } else {
        statusLabel.setText("Sign up failed. Please try again.");
    }
    
} catch (SQLException e) {
    statusLabel.setText("Database error: " + e.getMessage());
}
        System.out.println("Signing up...");
        System.out.printf("First Name: %s, Last Name: %s, Role: %s, Contact No: %s%n",
                firstName, lastName, role, contactNo);

        statusLabel.setText("Sign up successful!");
        
        // Clear fields after signing up
        clearFields();
    }

    // Event handler for the Log In hyperlink
    @FXML
    private void handleLoginLink() {
        System.out.println("Log In clicked!");
     
try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml")); // Update with your actual FXML file path
    Parent loginRoot = loader.load();
    Scene loginScene = new Scene(loginRoot);
    
    // Assuming you have a reference to the current stage
    Stage currentStage = (Stage) loginLink.getScene().getWindow(); // Use the hyperlink as a reference
    currentStage.setScene(loginScene);
    currentStage.show();
} catch (IOException e) {
    statusLabel.setText("Error navigating to login screen: " + e.getMessage());
}
    }

    // Method to clear input fields
    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        roleComboBox.getSelectionModel().clearSelection();
        countryCodeComboBox.getSelectionModel().clearSelection();
        contactNoField.clear();
    }
}
