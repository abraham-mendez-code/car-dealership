package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    // class attributes
    private final String contractDir = "src/main/resources/contracts.csv";

    public void saveContract(Contract contract) {


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(contractDir, true)))  { // create a bufferedWriter with appending enabled

            if (contract instanceof SalesContract salesContract) {
                // write contract specific info
                bufferedWriter.write("SALE|" + salesContract.getDate() + "|" + salesContract.getCustomerName() + "|" + salesContract.getCustomerEmail() + "|"
                        + salesContract.getVehicleSold().getVin() + "|" + salesContract.getVehicleSold().getYear() + "|"
                        + salesContract.getVehicleSold().getMake() + "|" + salesContract.getVehicleSold().getModel() + "|"
                        + salesContract.getVehicleSold().getVehicleType() + "|" + salesContract.getVehicleSold().getColor() + "|"
                        + salesContract.getVehicleSold().getOdometer() + "|" + salesContract.getVehicleSold().getPrice() + "|"
                        + salesContract.getVehicleSold() + "|" + salesContract.getRECORDING_FEE() + "|" + salesContract.getProcessingFee() + "|"
                        + salesContract.getTotalPrice() + "|" + (salesContract.isFinanced() ? "YES" : "NO") + "|" + salesContract.getMonthlyPayment());
                    bufferedWriter.newLine(); // end on a new line
            }
            else if (contract instanceof LeaseContract leaseContract) {
                // write contract specific information
                bufferedWriter.write("LEASE|" + leaseContract.getDate() + "|" + leaseContract.getCustomerName() + "|" + leaseContract.getCustomerEmail() + "|"
                        + leaseContract.getVehicleSold().getVin() + "|" + leaseContract.getVehicleSold().getYear() + "|"
                        + leaseContract.getVehicleSold().getMake() + "|" + leaseContract.getVehicleSold().getModel() + "|"
                        + leaseContract.getVehicleSold().getVehicleType() + "|" + leaseContract.getVehicleSold().getColor() + "|"
                        + leaseContract.getVehicleSold().getOdometer() + "|" + leaseContract.getVehicleSold().getPrice() + "|"
                        + leaseContract.getEndingValue() + "|" + leaseContract.getLeaseFee() + "|" + leaseContract.getMonthlyPayment());
                bufferedWriter.newLine();
            }

        }
        catch (IOException e) {

            System.out.println("Failed to write to the contracts file: " + e.getMessage());

        }
    }
}
