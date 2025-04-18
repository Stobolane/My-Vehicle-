package com.example.vehiclesystem;

public class PaymentManager {
    private String transactionId;
    private String customer;
    private double amount;
    private String status;
    private String date;

    public PaymentManager(String transactionId, String customer, double amount, String status, String date) {
        this.transactionId = transactionId;
        this.customer = customer;
        this.amount = amount;
        this.status = status;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }
}