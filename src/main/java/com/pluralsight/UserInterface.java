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

    public void processGetByMakeModelRequest() {


    }

    public void processGetByYearRequest() {


    }

    public void processGetByColorRequest() {


    }

    public void processGetByMileageRequest() {



    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetByAllVehicleRequest() {

        displayVehicles(this.dealership.getAllVehicles());

    }

    public void processAddVehicleRequest() {


    }

    public void processRemoveVehicleRequest() {



    }

    // private helper methods
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

        String input = String.format(
                "%s|%s|%s|%s|%s|%s|%s|%s",
                center("vin", 10),
                center("year", 10),
                center("make", 10),
                center("model", 10),
                center("vehicleType", 10),
                center("color", 10),
                center("odometer", 10),
                center("price", 10)
        );

        System.out.println(input);

        for (int i = 0; i < input.length(); i++){
            System.out.print("=");
        }
        System.out.println();

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
            input = String.format(
                    "%s|%s|%s|%s|%s|%s|%s|%s",
                    center(vin, 10),
                    center(year, 10),
                    center(make, 10),
                    center(model, 10),
                    center(vehicleType, 10),
                    center(color, 10),
                    center(odometer, 10),
                    center(price, 10)
            );

            System.out.println(input);
        }

    }

    // this method returns a centered input string
    private static String center(String text, int width) {
        if (text == null || width <= text.length()) {
            return text;
        }
        int padding = width - text.length();
        int padStart = padding / 2;
        int padEnd = padding - padStart;
        return " ".repeat(padStart) + text + " ".repeat(padEnd);
    }

    private static String center(int input, int width) {
        String text = String.valueOf(input);
        if (text == null || width <= text.length()) {
            return text;
        }
        int padding = width - text.length();
        int padStart = padding / 2;
        int padEnd = padding - padStart;
        return " ".repeat(padStart) + text + " ".repeat(padEnd);
    }

    private static String center(double input, int width) {

        String text = String.valueOf(input);

        if (text == null || width <= text.length()) {
            return text;
        }
        int padding = width - text.length();
        int padStart = padding / 2;
        int padEnd = padding - padStart;
        return " ".repeat(padStart) + text + " ".repeat(padEnd);
    }

}
