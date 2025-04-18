package com.example.vehiclesystem.controllers;

import com.example.vehiclesystem.DatabaseConnection;
import com.example.vehiclesystem.PasswordUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private ComboBox<String> roleComboBox;
    @FXML private Button loginButton;
    @FXML private Button registerButton;

    @FXML
    public void initialize() {
        roleComboBox.getItems().addAll("Admin", "Employee");
        roleComboBox.getSelectionModel().selectFirst(); // Select first item by default
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        String role = roleComboBox.getValue();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please enter both username and password");
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT password FROM users WHERE username = ? AND role = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, role);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                handlePasswordVerification(password, storedPassword, username, role);
            } else {
                showAlert("Error", "User not found!");
            }
        } catch (SQLException | IOException e) {
            showAlert("Database Error", "Error during login: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handlePasswordVerification(String inputPassword, String storedPassword,
                                            String username, String role) throws IOException {
        if (storedPassword.contains(":")) {
            // Handle hashed password
            String[] passwordParts = storedPassword.split(":");
            if (passwordParts.length != 2 || !PasswordUtils.verifyPassword(inputPassword,
                    passwordParts[0], passwordParts[1])) {
                showAlert("Error", "Invalid credentials!");
                return;
            }
        } else if (!storedPassword.equals(inputPassword)) {
            // Plain text fallback
            showAlert("Error", "Invalid credentials!");
            return;
        }

        redirectToDashboard(username, role);
    }

    private void redirectToDashboard(String username, String role) throws IOException {
        String fxmlPath = role.equals("Admin")
                ? "/com/example/vehiclesystem/AdminDash.fxml"
                : "/com/example/vehiclesystem/EmployeeDash.fxml";

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();

        if (role.equals("Admin")) {
            AdminDash controller = loader.getController();
            controller.setCurrentUser(username);
        } else {
            EmployeeDashController controller = loader.getController();
            controller.setCurrentUser(username);
        }

        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle(role + " Dashboard");
        stage.show();
    }

    @FXML
    private void goToRegister() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/vehiclesystem/register.fxml"));
            Stage stage = (Stage) registerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Registration");
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load registration page: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}