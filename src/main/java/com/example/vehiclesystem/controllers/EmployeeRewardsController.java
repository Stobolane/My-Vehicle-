package com.example.vehiclesystem.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeRewardsController {

    @FXML private TableView<Reward> rewardsTable;
    @FXML private TableColumn<Reward, String> rewardTypeColumn;
    @FXML private TableColumn<Reward, Integer> pointsColumn;
    @FXML private TableColumn<Reward, String> dateAwardedColumn;

    private ObservableList<Reward> rewards = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        rewardTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        dateAwardedColumn.setCellValueFactory(new PropertyValueFactory<>("dateAwarded"));

        // Sample data
        rewards.addAll(
                new Reward("Top Seller", 150, "2025-03-15"),
                new Reward("Customer Favorite", 100, "2025-02-01")
        );

        rewardsTable.setItems(rewards);
    }

    public static class Reward {
        private String type;
        private int points;
        private String dateAwarded;

        public Reward(String type, int points, String dateAwarded) {
            this.type = type;
            this.points = points;
            this.dateAwarded = dateAwarded;
        }

        public String getType() { return type; }
        public int getPoints() { return points; }
        public String getDateAwarded() { return dateAwarded; }
    }
}