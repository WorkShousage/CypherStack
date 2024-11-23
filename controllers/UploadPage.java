import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class UploadController {

    @FXML
    private Label nameLabel; // Label to display file name
    @FXML
    private Label sizeLabel; // Label to display file size
    @FXML
    private Label typeLabel; // Label to display file type
    @FXML
    private RadioButton localStorageRadioButton; // RadioButton for Local Storage
    @FXML
    private RadioButton cloudStorageRadioButton; // RadioButton for Cloud Storage
    @FXML
    private Button browseButton; // Button to browse files
    @FXML
    private Button uploadButton; // Button to upload files

    // This method is called when the "Browse" button is clicked
    @FXML
    private void handleBrowseButtonAction() {
        FileChooser fileChooser = new FileChooser();
        // Set extension filters if needed
        File selectedFile = fileChooser.showOpenDialog((Stage) browseButton.getScene().getWindow());
        if (selectedFile != null) {
            // Display file information
            nameLabel.setText(selectedFile.getName());
            sizeLabel.setText(selectedFile.length() + " bytes");
            typeLabel.setText(getFileExtension(selectedFile));
        }
    }

    // This method is called when the "Upload" button is clicked
    @FXML
    private void handleUploadButtonAction() {
        // Implement upload logic here based on selected storage option
        if (localStorageRadioButton.isSelected()) {
            // Handle local storage upload
            System.out.println("Uploading to Local Storage...");
        } else if (cloudStorageRadioButton.isSelected()) {
            // Handle cloud storage upload
            System.out.println("Uploading to Cloud Storage...");
        } else {
            // No option selected
            System.out.println("Please select a storage option.");
        }
    }

    // Utility method to get file extension
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOfDot = name.lastIndexOf('.');
        if (lastIndexOfDot > 0 && lastIndexOfDot < name.length() - 1) {
            return name.substring(lastIndexOfDot + 1);
        }
        return "Unknown";
    }
}
