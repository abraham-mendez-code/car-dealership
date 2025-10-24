package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    // private attributes
    private static final String inventoryDir = "src/main/resources/inventory.csv";

    // private constructor
    private DealershipFileManager() {}

    // this method reads and loads the inventory file into a list of Vehicles and returns a Dealership
    public static Dealership getDealership() {

        try {
            // this bufferedReader reads the inventory file
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
                tokens  = input.split("[|]");

                int vin = Integer.parseInt(tokens[0]);
                int year = Integer.parseInt(tokens[1]);
                String make = tokens[2];
                String model = tokens[3];
                String vehicleType = tokens[4];
                String color = tokens [5];
                int odometer = Integer.parseInt(tokens[6]);
                double price = Double.parseDouble(tokens[7]);

                dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));


            }

            return dealership;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void saveDealership(Dealership dealership) {



    }

}
