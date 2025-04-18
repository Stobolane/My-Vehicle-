package com.example.vehiclesystem;

import com.example.vehiclesystem.models.LogEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

public class ActivityLogs {

    @FXML private TableView<LogEntry> logsTable;
    @FXML private TableColumn<LogEntry, LocalDateTime> dateTimeCol;
    @FXML private TableColumn<LogEntry, String> userCol;
    @FXML private TableColumn<LogEntry, String> actionCol;

    @FXML
    public void initialize() {
        dateTimeCol.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("user"));
        actionCol.setCellValueFactory(new PropertyValueFactory<>("action"));

        logsTable.setItems(getSampleLogs()); // Replace this later with DB logs
    }

    private ObservableList<LogEntry> getSampleLogs() {
        return FXCollections.observableArrayList(
                new LogEntry(LocalDateTime.now(), "admin", "Logged in"),
                new LogEntry(LocalDateTime.now().minusHours(1), "manager1", "Viewed reports")
        );
    }
}