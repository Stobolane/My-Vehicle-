package com.example.vehiclesystem;

public class Payment {
    private String transactionId;
    private String customer;
    private double amount;
    private String status;
    private String date;

    // For dummy/test data in PaymentsController
    public Payment(String transactionId, String customer, double amount, String status, String date) {
        this.transactionId = transactionId;
        this.customer = customer;
        this.amount = amount;
        this.status = status;
        this.date = date;
    }

    // For actual data loading in EmployeePayment
    private int paymentId;
    private int rentalId;
    private String customerName;
    private String paymentMethod;

    public Payment(int paymentId, int rentalId, String customerName, double amount, String paymentDate, String paymentMethod, String status) {
        this.paymentId = paymentId;
        this.rentalId = rentalId;
        this.customerName = customerName;
        this.amount = amount;
        this.date = paymentDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    // Getters for both use cases
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

    public int getPaymentId() {
        return paymentId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMethod() {
        return paymentMethod;
    }
}