package com.pluralsight;

public class SalesContract extends Contract {

    // class attributes
    private final double SALES_TAX = .05;
    private final double RECORDING_FEE = 100;

    private double processingFee;
    private boolean isFinanced;
    private double monthlyPayment;

    // constructor
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {

        super(date, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;

        processingFee = ( vehicleSold.getPrice() < 10000 ? 295 : 495 ); // the processing fee 295 for vehicles less than 10,000, for all other vehicles the fee is 495

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
