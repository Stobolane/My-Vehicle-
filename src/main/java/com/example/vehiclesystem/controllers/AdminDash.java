package com.example.vehiclesystem.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import java.net.URL;

public class AdminDash {
    @FXML private Label welcomeLabel;
    @FXML private StackPane contentPane;

    private String currentUsername;

    public void initialize() {
        welcomeLabel.setText("Welcome, " + (currentUsername != null ? currentUsername : "Admin"));
    }

    public void setCurrentUser(String username) {
        this.currentUsername = username;
        if (welcomeLabel != null) {
            welcomeLabel.setText("Welcome, " + username);
        }
    }

    @FXML
    private void showDashboard() {
        loadContent("/com/example/vehiclesystem/admin_home.fxml");
    }

    @FXML
    private void showVehicleManagement() {
        loadContent("/com/example/vehiclesystem/admin_vehicles.fxml");
    }

    @FXML
    private void showCustomerManagement() {
        loadContent("/com/example/vehiclesystem/Manage_Customers.fxml");
    }

    @FXML
    private void showUserManagement() {
        loadContent("/com/example/vehiclesystem/Manage_Users.fxml");
    }

    @FXML
    private void showReports() {
        loadContent("/com/example/vehiclesystem/Manage_Reports.fxml");
    }

    @FXML
    private void showActivityLogs() {
        loadContent("/com/example/vehiclesystem/admin_activity_logs.fxml");
    }

    @FXML
    private void showPayments() {
        loadContent("/com/example/vehiclesystem/admin_payments.fxml");
    }

    @FXML
    private void handleLogout() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/vehiclesystem/login.fxml"));
            contentPane.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadContent(String fxmlPath) {
        try {
            URL url = getClass().getResource(fxmlPath);
            if (url == null) {
                System.err.println("FXML file not found at: " + fxmlPath);
                return;
            }
            Parent content = FXMLLoader.load(url);
            contentPane.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}