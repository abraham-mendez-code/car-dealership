package com.pluralsight;

public abstract class Contract {

    // class attributes
    String date;
    String customerName;
    String customerEmail;
    String vehicleSold;
    double totalPrice;
    double monthlyPayment;

    // constructor
    public Contract (String date, String customerName, String customerEmail, String vehicleSold ) {

        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;

    }

    // getter methods
    public String getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getVehicleSold() {
        return vehicleSold;
    }

    // setter methods
    public void setDate(String date) {
        this.date = date;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setVehicleSold(String vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    // Abstract methods
    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
