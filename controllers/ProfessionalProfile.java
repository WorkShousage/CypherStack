import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MainController {

    @FXML
    private TextField companyNameField; // TextField for company name input
    @FXML
    private TextField employeeIdField; // TextField for employee ID input
    @FXML
    private TextField departmentField; // TextField for department input
    @FXML
    private TextField workAddressField; // TextField for work address input
    @FXML
    private TextField jobTitleField; // TextField for job title input

    @FXML
    private Button saveButton; // Button to save the information
    @FXML
    private Button cancelButton; // Button to cancel the operation
    @FXML
    private Button personalInfoButton; // Button for personal info
    @FXML
    private Button professionalInfoButton; // Button for professional info
    @FXML
    private Button uploadButton; // Button for uploading files

    @FXML
    private Label statusLabel; // Optional label for status messages

    // Initialize method to set up initial state
    @FXML
    public void initialize() {
        statusLabel.setText(""); // Clear status label on initialization
    }

    // Event handler for the Save button
    @FXML
    private void handleSaveButton() {
        String companyName = companyNameField.getText().trim();
        String employeeId = employeeIdField.getText().trim();
        String department = departmentField.getText().trim();
        String workAddress = workAddressField.getText().trim();
        String jobTitle = jobTitleField.getText().trim();

        // Basic validation
        if (companyName.isEmpty() || employeeId.isEmpty() || department.isEmpty() ||
            workAddress.isEmpty() || jobTitle.isEmpty()) {
            statusLabel.setText("Please fill in all fields.");
            return;
        }

        // Logic to save the information (e.g., to a database or file)
        System.out.println("Saving information...");
        System.out.printf("Company: %s, Employee ID: %s, Department: %s, Address: %s, Job Title: %s%n",
                companyName, employeeId, department, workAddress, jobTitle);

        statusLabel.setText("Information saved successfully!");
        
        // Clear fields after saving
        clearFields();
    }

    // Event handler for the Cancel button
    @FXML
    private void handleCancelButton() {
        clearFields();
        statusLabel.setText("Operation canceled.");
    }

    // Event handler for the Personal Info button
    @FXML
    private void handlePersonalInfoButton() {
        System.out.println("Personal Info clicked!");
        // Logic to navigate to the personal info section
    }

    // Event handler for the Professional Info button
    @FXML
    private void handleProfessionalInfoButton() {
        System.out.println("Professional Info clicked!");
        // Logic to navigate to the professional info section
    }

    // Event handler for the Upload button
    @FXML
    private void handleUploadButton() {
        System.out.println("Upload clicked!");
        // Logic to handle file upload
    }

    // Method to clear input fields
    private void clearFields() {
        companyNameField.clear();
        employeeIdField.clear();
        departmentField.clear();
        workAddressField.clear();
        jobTitleField.clear();
    }
}
