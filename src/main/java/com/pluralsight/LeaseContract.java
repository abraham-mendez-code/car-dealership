package com.pluralsight;

public class LeaseContract extends Contract{

    // class attributes
    double endingValue;
    double leaseFee;

    // constructor
    public LeaseContract (String date, String customerName, String customerEmail, Vehicle vehicleSold) {

        super(date, customerName, customerEmail, vehicleSold);

        this.endingValue = vehicleSold.getPrice() * .5; // expected ending value (50% of the original price)
        this.leaseFee = vehicleSold.getPrice() * .07; // lease fee (7% of the original price)

    }

    // getter and setter methods
    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    // overridden abstract methods
    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
