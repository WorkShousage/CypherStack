package com.cypherstack.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the login page (from the views directory)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Login.fxml"));
            Parent root = loader.load();

            // Set up the scene with the login page
            Scene scene = new Scene(root);

            // Add a stylesheet for styling (optional)
            scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());

            // Configure the primary stage
            primaryStage.setTitle("CypherStack");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
