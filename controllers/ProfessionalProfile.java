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

try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_data.txt", true))) {
    writer.write(String.format("Company: %s, Employee ID: %s, Department: %s, Address: %s, Job Title: %s%n",
            companyName, employeeId, department, workAddress, jobTitle));
    statusLabel.setText("Information saved successfully!");
    clearFields();
} catch (IOException e) {
    statusLabel.setText("Error saving information: " + e.getMessage());
}
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
      
try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("personal_info.fxml")); // Update with your FXML file path
    Parent personalInfoRoot = loader.load();
    Scene personalInfoScene = new Scene(personalInfoRoot);
    
    // Assuming you have a reference to the current stage
    Stage currentStage = (Stage) someNode.getScene().getWindow(); // Replace 'someNode' with an actual node reference
    currentStage.setScene(personalInfoScene);
    currentStage.show();
} catch (IOException e) {
    statusLabel.setText("Error navigating to personal info section: " + e.getMessage());
}
    }

    // Event handler for the Professional Info button
    @FXML
    private void handleProfessionalInfoButton() {
        System.out.println("Professional Info clicked!");
     
try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("professional_info.fxml")); // Update with your FXML file path
    Parent professionalInfoRoot = loader.load();
    Scene professionalInfoScene = new Scene(professionalInfoRoot);
    
    // Assuming you have a reference to the current stage
    Stage currentStage = (Stage) someNode.getScene().getWindow(); // Replace 'someNode' with an actual node reference
    currentStage.setScene(professionalInfoScene);
    currentStage.show();
} catch (IOException e) {
    statusLabel.setText("Error navigating to professional info section: " + e.getMessage());
}
    }

    // Event handler for the Upload button
    @FXML
    private void handleUploadButton() {
        System.out.println("Upload clicked!");

FileChooser fileChooser = new FileChooser();
fileChooser.setTitle("Select a File");
fileChooser.getExtensionFilters().addAll(
    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
    new FileChooser.ExtensionFilter("All Files", "*.*")
);

File selectedFile = fileChooser.showOpenDialog(someNode.getScene().getWindow()); // Replace 'someNode' with an actual node reference
if (selectedFile != null) {
    try {
        // Process the file (e.g., read its contents)
        List<String> lines = Files.readAllLines(selectedFile.toPath());
        // You can do something with the lines here, e.g., display or save them
        statusLabel.setText("File uploaded successfully: " + selectedFile.getName());
    } catch (IOException e) {
        statusLabel.setText("Error reading file: " + e.getMessage());
    }
} else {
    statusLabel.setText("File selection was canceled.");
}
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
