package com.cypherstack.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private Stage stage;

    public SceneManager(Stage stage) {
        this.stage = stage;
    }

    /**
     * Load and switch to a new scene.
     * 
     * @param fxmlFile The FXML file to load.
     * @param title The title for the new window.
     * @param resizable Whether the window should be resizable.
     */
    public void changeScene(String fxmlFile, String title, boolean resizable) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/" + fxmlFile));
            Parent root = loader.load();

            // Create a new scene and set it in the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Set the title and resizability for the stage
            stage.setTitle(title);
            stage.setResizable(resizable);

            // Show the stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Load and switch to the login scene.
     */
    public void showLoginScene() {
        changeScene("Login.fxml", "Login - CypherStack", false);
    }

    /**
     * Load and switch to the signup scene.
     */
    public void showSignupScene() {
        changeScene("Signup.fxml", "Signup - CypherStack", false);
    }

    /**
     * Load and switch to the manager dashboard.
     */
    public void showManagerDashboard() {
        changeScene("ManagerDashboard.fxml", "Manager Dashboard - CypherStack", true);
    }

    /**
     * Load and switch to the employee dashboard.
     */
    public void showEmployeeDashboard() {
        changeScene("EmployeeDashboard.fxml", "Employee Dashboard - CypherStack", true);
    }

    /**
     * Load and switch to a common view (if applicable).
     */
    public void showCommonView() {
        changeScene("CommonView.fxml", "Common View - CypherStack", true);
    }
}
