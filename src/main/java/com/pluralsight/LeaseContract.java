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

        double total =  endingValue + leaseFee + monthlyPayment * 36;

        return total;
    }

    @Override
    public double getMonthlyPayment() {

        /*
            Standard loan payment formula:
                M = (r x P) / 1 - (1 + r)^-n
            M = monthly payment
            P = principle (price or loan amount)
            r = monthly interest rate (annual rate / 12)
            n = total number of payments (months)

            All leases are financed at 4.0% for 36 months
         */

        // declare formula variables
        double m;
        double p = vehicleSold.getPrice(); // assign the vehicle price
        double r = .04 / 12;
        double n = 36;

        m = (r * p) / (1 - Math.pow((1 + r), -n)); // calculate monthly payment

        return m;
    }
}
