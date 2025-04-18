module com.example.vehiclesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.swing;
    requires org.apache.pdfbox;

    opens com.example.vehiclesystem to javafx.fxml;
    opens com.example.vehiclesystem.controllers to javafx.fxml;
    opens com.example.vehiclesystem.models to javafx.base; // <-- Added for PropertyValueFactory reflection

    exports com.example.vehiclesystem;
    exports com.example.vehiclesystem.controllers;
}