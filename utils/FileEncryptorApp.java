import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.nio.file.Path;

public class FileEncryptorApp extends Application {

    private Label statusLabel;
    private Path selectedFilePath; // Store the selected file path
    private final FileEncryptorBackend backend = new FileEncryptorBackend(); // Instantiate backend

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Encryptor");

        // Create UI elements
        Label heading = new Label("FileEncryptorApp");
        heading.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");
        Button btnEncrypt = new Button("Select File to Encrypt");
        Button btnDecrypt = new Button("Select File to Decrypt");
        statusLabel = new Label("Status: ");

        // Setting up the layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setStyle("-fx-background-color: #5A5A5A;");
        gridPane.add(heading, 0, 0);
        gridPane.add(btnEncrypt, 0, 1);
        gridPane.add(btnDecrypt, 0, 2);
        gridPane.add(statusLabel, 0, 3);

        // Button actions
        btnEncrypt.setOnAction(e -> selectFileToEncrypt());
        btnDecrypt.setOnAction(e -> selectFileToDecrypt());

        // Create and display the scene
        Scene scene = new Scene(gridPane, 400, 300); // Increased height for heading
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void selectFileToEncrypt() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File to Encrypt");
        selectedFilePath = fileChooser.showOpenDialog(null).toPath();

        if (selectedFilePath != null) {
            PasswordField keyField = new PasswordField();
            keyField.setPromptText("Enter Key for Encryption");

            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Encryption Key");
            dialog.setHeaderText("Enter the key for encryption:");
            dialog.getDialogPane().setContent(keyField);

            ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

            dialog.setResultConverter(button -> {
                if (button == okButton) {
                    return keyField.getText();
                }
                return null;
            });

            dialog.showAndWait().ifPresent(keyString -> {
                try {
                    backend.encryptFile(selectedFilePath, keyString); // Use backend for encryption
                    statusLabel.setText("File successfully encrypted: " + selectedFilePath.toString());
                } catch (Exception ex) {
                    showErrorMessage("Error during encryption: " + ex.getMessage());
                }
            });
        } else {
            showErrorMessage("No file selected for encryption.");
        }
    }

    private void selectFileToDecrypt() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Encrypted File");
        Path encryptedFilePath = fileChooser.showOpenDialog(null).toPath();

        if (encryptedFilePath != null) {
            PasswordField keyField = new PasswordField();
            keyField.setPromptText("Enter Key for Decryption");

            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Decryption Key");
            dialog.setHeaderText("Enter the key for decryption:");
            dialog.getDialogPane().setContent(keyField);

            ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

            dialog.setResultConverter(button -> {
                if (button == okButton) {
                    return keyField.getText();
                }
                return null;
            });

            dialog.showAndWait().ifPresent(keyString -> {
                try {
                    backend.decryptFile(encryptedFilePath, keyString); // Use backend for decryption
                    statusLabel.setText("File successfully decrypted: " + encryptedFilePath.toString());
                } catch (Exception e) {
                    showErrorMessage("Decryption Error: " + e.getMessage());
                }
            });
        } else {
            showErrorMessage("No file selected for decryption.");
        }
    }

    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
