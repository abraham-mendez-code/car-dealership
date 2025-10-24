package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

    // private attributes
    private static final String inventoryDir = "src/main/resources/inventory.csv";

    // private constructor
    private DealershipFileManager() {}

    // this method reads and loads the inventory file into a list of Vehicles and returns a Dealership
    public static Dealership getDealership() {

        try {
            // this BufferedReader reads the inventory file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inventoryDir));

            // this reads the first line and splits it into tokens
            String input = bufferedReader.readLine();
            String[] tokens = input.split("[|]");

            // assign the tokens to attributes for a new dealership
            String name = tokens[0];
            String address = tokens[1];
            String phone = tokens[2];

            // create a new Dealership with the attributes
            Dealership dealership = new Dealership(name, address, phone);


            // this loop reads the rest of the file and adds a new vehicle to the leadership for each entry
            while ( (input = bufferedReader.readLine()) != null) {
                // split the current line into tokens
                tokens  = input.split("[|]");

                // assign the Vehicle attributes the value of each expected token
                int vin = Integer.parseInt(tokens[0]);
                int year = Integer.parseInt(tokens[1]);
                String make = tokens[2];
                String model = tokens[3];
                String vehicleType = tokens[4];
                String color = tokens [5];
                int odometer = Integer.parseInt(tokens[6]);
                double price = Double.parseDouble(tokens[7]);

                // add a new Vehicle with the parsed attributes to the Dealership
                dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));


            }
            bufferedReader.close();

            // return the dealership
            return dealership;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // this method overwrites the inventory file with the current dealership information and inventory list
    public static void saveDealership(Dealership dealership) {

        try {
            // this BufferedWrite overwrites the inventory file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(inventoryDir));

            // get the attributes for the dealership
            String name = dealership.getName();
            String address = dealership.getAddress();
            String phone = dealership.getPhone();

            // format the attributes into an input string
            String input = String.format("%s|%s|%s\n", name, address, phone);

            // write the input to the first line
            bufferedWriter.write(input);

            // this loop writes all Vehicles in the Dealership to the inventory file
            for ( Vehicle vehicle: dealership.getAllVehicles() ) {

                // get the attributes for the current vehicle
                int vin = vehicle.getVin();
                int year = vehicle.getYear();
                String make = vehicle.getMake();
                String model = vehicle.getModel();
                String vehicleType = vehicle.getVehicleType();
                String color = vehicle.getColor();
                int odometer = vehicle.getOdometer();
                double price = vehicle.getPrice();

                // assign the attributes to a formated input String
                input = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n", vin, year, make, model, vehicleType, color, odometer, price);

                // write the input to the inventory file
                bufferedWriter.write(input);

            }
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
