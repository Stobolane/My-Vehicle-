package com.example.vehiclesystem.controllers;

import com.example.vehiclesystem.Payment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PaymentsController {

    @FXML private TableView<Payment> paymentsTable;
    @FXML private TableColumn<Payment, String> transIdCol;
    @FXML private TableColumn<Payment, String> customerCol;
    @FXML private TableColumn<Payment, Double> amountCol;
    @FXML private TableColumn<Payment, String> statusCol;
    @FXML private TableColumn<Payment, String> dateCol;

    @FXML
    public void initialize() {
        // Initialize columns with proper property names
        transIdCol.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        customerCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));  // Changed to match likely getter
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));  // Changed to match likely getter
        dateCol.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));  // Changed to match likely getter

        paymentsTable.setItems(getDummyPayments());
    }

    private ObservableList<Payment> getDummyPayments() {
        ObservableList<Payment> payments = FXCollections.observableArrayList();

        // Create payments using proper constructor
        payments.add(new Payment(
                "TX001",
                "John Doe",
                150.0,
                "Paid",
                "2025-04-18"
        ));

        payments.add(new Payment(
                "TX002",
                "Jane Smith",
                220.5,
                "Pending",
                "2025-04-17"
        ));

        return payments;
    }
}