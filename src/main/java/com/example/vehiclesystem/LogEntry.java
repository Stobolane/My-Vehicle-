package com.example.vehiclesystem.models;

import java.time.LocalDateTime;

public class LogEntry {
    private LocalDateTime dateTime;
    private String user;
    private String action;

    public LogEntry(LocalDateTime dateTime, String user, String action) {
        this.dateTime = dateTime;
        this.user = user;
        this.action = action;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getUser() {
        return user;
    }

    public String getAction() {
        return action;
    }
}