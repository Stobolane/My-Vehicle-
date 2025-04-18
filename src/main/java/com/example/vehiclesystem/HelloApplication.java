package com.example.vehiclesystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    HelloApplication.class.getResource("/com/example/vehiclesystem/home.fxml")
            );
            Scene scene = new Scene(fxmlLoader.load(), 800, 500);
            stage.setTitle("Vehicle Rental System");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println("FXML Load Error:");
            e.printStackTrace();
            throw e; // Re-throw to see complete stack trace
        }
    }

    public static void main(String[] args) {
        launch();
    }
}