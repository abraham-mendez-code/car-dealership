package com.pluralsight;

public class SalesContract extends Contract {

    // Constructor
    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold) {

        super(date, customerName, customerEmail, vehicleSold);

    }

    // override contract abstract methods
    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }

}
