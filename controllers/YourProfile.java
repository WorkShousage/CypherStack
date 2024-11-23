import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ProfileController {

    @FXML
    private ImageView profileImageView; // ImageView for profile image
    @FXML
    private TextField firstNameField; // TextField for first name
    @FXML
    private TextField lastNameField; // TextField for last name
    @FXML
    private TextField emailField; // TextField for email
    @FXML
    private TextField addressField; // TextField for address
    @FXML
    private TextField contactNumberField; // TextField for contact number
    @FXML
    private ComboBox<String> cityComboBox; // ComboBox for city
    @FXML
    private ComboBox<String> stateComboBox; // ComboBox for state
    @FXML
    private Button saveButton; // Button to save changes
    @FXML
    private Button cancelButton; // Button to cancel changes
    @FXML
    private Button uploadButton; // Button to upload profile image

    // This method is called when the "Upload +" button is clicked
    @FXML
    private void handleUploadButtonAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog((Stage) uploadButton.getScene().getWindow());
        if (selectedFile != null) {
            // Load the selected image into the ImageView
            profileImageView.setImage(new Image(selectedFile.toURI().toString()));
        }
    }

    // This method is called when the "Save" button is clicked
    @FXML
    private void handleSaveButtonAction() {
        // Retrieve data from the fields
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String contactNumber = contactNumberField.getText();
        String city = cityComboBox.getValue();
        String state = stateComboBox.getValue();

        // Here you can implement logic to save the data, e.g., to a database or file
        System.out.println("Profile saved!");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
    }

    // This method is called when the "Cancel" button is clicked
    @FXML
    private void handleCancelButtonAction() {
        // Logic to handle cancellation, such as clearing fields or closing the window
        System.out.println("Changes canceled.");
        // Optionally, you can clear the fields
        clearFields();
    }

    // Utility method to clear input fields
    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        addressField.clear();
        contactNumberField.clear();
        cityComboBox.getSelectionModel().clearSelection();
        stateComboBox.getSelectionModel().clearSelection();
    }
}
