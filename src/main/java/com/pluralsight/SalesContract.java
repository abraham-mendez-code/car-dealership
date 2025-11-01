package com.pluralsight;

public class SalesContract extends Contract {

    // class attributes
    double SALES_TAX = .05;
    double RECORDING_FEE = 100;

    private double processingFee;
    private boolean isFinanced;
    private double monthlyPayment;
    private double principle;

    // constructor
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced, double principle) {

        super(date, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
        this.principle = principle;

        processingFee = ( vehicleSold.getPrice() < 10000 ? 295 : 495 ); // the processing fee 295 for vehicles less than 10,000, for all other vehicles the fee is 495

    }

    // override contract abstract methods
    @Override
    public double getTotalPrice() {

        /*
            Total formula
                sum = tax + recordingFee + processingFee + monthlyPayment total
         */

        return ( vehicleSold.getPrice() * SALES_TAX ) + RECORDING_FEE + processingFee + getMonthlyPayment() * (vehicleSold.getPrice()) < 10000 ? 24 : 48;
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

            If price ≥ $10,000
                → annual rate = 4.25% = 0.0425
                → term = 48 months
            If price < $10,000
                → annual rate = 5.25% = 0.0525
                → term = 24 months
        */

        // declare formula variables
        double m;
        double p = principle; // assign the vehicle price
        double r;
        double n;

        // check if the vehicle is financed
        if (isFinanced) {
            // check the price and apply the rates per case
            if (p >= 10000) {
                r = .0425 / 12;
                n = 48;
            } else {
                r = .0525 / 12;
                n = 24;
            }

            m = (r * p) / (1 - Math.pow((1 + r), -n)); // calculate monthly payment

            return m;
        }

        return 0; // if not financed there is no monthly payment

    }

}
