package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    // private attributes
    private Dealership dealership;

    // public constructor
    public UserInterface() {
    }

    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        init();

        while(true) {
            try {
                // this prints out the mainMenu display
                System.out.println(mainMenu());
                // try to parse for a command
                int command = Integer.parseInt(scanner.nextLine());

                // call a method based on input command or exit the loop
                switch (command) {
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processGetByAllVehicleRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 0:
                        return;
                }

            } catch (NumberFormatException e) { // User did not enter a number...
                System.out.println("Command must be a number");
            }
        }

    }

    public void processGetByPriceRequest() {

    }

    public static void processGetByMakeModelRequest() {


    }

    public static void processGetByYearRequest() {


    }

    public static void processGetByColorRequest() {


    }

    public static void processGetByMileageRequest() {



    }

    public static void processGetByVehicleTypeRequest() {

    }

    public static void processGetByAllVehicleRequest() {


    }

    public static void processAddVehicleRequest() {


    }

    public static void processRemoveVehicleRequest() {



    }

    // helper methods
    private String mainMenu() {

        return """
                
                .------------------------------------------------------------------.
                | _____             ______           _               _     _       |
                |/  __ \\            |  _  \\         | |             | |   (_)      |
                || /  \\/ __ _ _ __  | | | |___  __ _| | ___ _ __ ___| |__  _ _ __  |
                || |    / _` | '__| | | | / _ \\/ _` | |/ _ \\ '__/ __| '_ \\| | '_ \\ |
                || \\__/\\ (_| | |    | |/ /  __/ (_| | |  __/ |  \\__ \\ | | | | |_) ||
                | \\____/\\__,_|_|    |___/ \\___|\\__,_|_|\\___|_|  |___/_| |_|_| .__/ |
                |                                                           | |    |
                |                                                           |_|    |
                '------------------------------------------------------------------'
                
                Available commands
                1 - Search vehicles by price
                2 - Search vehicles by make and model
                3 - Search vehicles by year
                4 - Search vehicles by color
                5 - Search vehicles by mileage
                6 - Search vehicles by type
                7 - View all Vehicles
                8 - Add Inventory
                9 - Remove Inventory
                0 - Exit
                Enter a command:\s""";
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {

        for (Vehicle vehicle: vehicles) {

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
            String input = String.format("%-10d|%-10d|%-10s|%-10s|%-10s|%-10s|%-10d|%-10.2f");

            System.out.println(input);
        }

    }

}
