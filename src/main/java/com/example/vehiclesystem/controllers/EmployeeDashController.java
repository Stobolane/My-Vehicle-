package com.example.vehiclesystem.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class EmployeeDashController {
    @FXML private Label welcomeLabel;
    @FXML private StackPane contentPane;

    private String currentUsername;

    @FXML
    public void initialize() {
        // Initialize the dashboard
        welcomeLabel.setText("Welcome, " + (currentUsername != null ? currentUsername : "Employee"));
    }

    public void setCurrentUser(String username) {
        this.currentUsername = username;
        if (welcomeLabel != null) {
            welcomeLabel.setText("Welcome, " + username);
        }
    }

    @FXML
    private void showDashboard() {
        loadContent("/com/example/vehiclesystem/employee_home.fxml");
    }

    @FXML
    private void showNewBooking() {
        loadContent("/com/example/vehiclesystem/New_Bookings.fxml");
    }

    @FXML
    private void showManageBookings() {
        loadContent("/com/example/vehiclesystem/EmployeeManageBookings.fxml");
    }

    @FXML
    private void showPayments() {
        loadContent("/com/example/vehiclesystem/EmployeePayment.fxml");
    }

    @FXML
    private void showEmployeeRewards() {
        loadContent("/com/example/vehiclesystem/EmployeeRewards.fxml");
    }


    @FXML
    private void handleLogout() {
        try {
            // Load the login screen
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/vehiclesystem/login.fxml"));
            Stage stage = (Stage) contentPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to logout", e.getMessage());
        }
    }

    private void loadContent(String fxmlPath) {
        try {
            Parent content = FXMLLoader.load(getClass().getResource(fxmlPath));
            contentPane.getChildren().clear();
            contentPane.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load content", e.getMessage());
        }
    }

    private void showAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    private void showProcessPayments() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vehiclesystem/EmployeePayment.fxml"));
            Parent view = loader.load();
            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}