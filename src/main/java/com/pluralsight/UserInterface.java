package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    // private attributes
    private Dealership dealership;
    Scanner scanner = new Scanner(System.in);

    // public constructor
    public UserInterface() {
    }

    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }

    public void display() {

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

        double min;
        double max;

        // this loop will prompt for min value input until valid input is entered
        while (true) {
            try {
                System.out.print("Enter a min value: ");
                min = Double.parseDouble(scanner.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Only numbers are allowed.");
            }
        }

        // this loop will prompt for max value input until valid input is entered
        while (true) {
            try {
                System.out.print("Enter a max value: ");
                max = Double.parseDouble(scanner.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Only numbers are allowed.");
            }
        }

        // perform search and display result
        displayVehicles(this.dealership.getVehiclesByPrice(min, max));

    }

    public void processGetByMakeModelRequest() {
        String make = "";
        String model = "";

        // get user input
        System.out.print("Enter the make: ");
        make = scanner.nextLine().trim();

        System.out.print("Enter the model: ");
        model = scanner.nextLine().trim();

        // perform search and display result
        displayVehicles(this.dealership.getVehiclesByMakeModel(make, model));

    }

    public void processGetByYearRequest() {

        int min;
        int max;

        // this loop will prompt for min value input until valid input is entered
        while (true) {
            try {
                System.out.print("Enter a min value: ");
                min = Integer.parseInt(scanner.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Only numbers are allowed.");
            }
        }

        // this loop will prompt for max value input until valid input is entered
        while (true) {
            try {
                System.out.print("Enter a max value: ");
                max = Integer.parseInt(scanner.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Only numbers are allowed.");
            }
        }

        // perform search and display result
        displayVehicles(this.dealership.getVehiclesByYear(min, max));

    }

    public void processGetByColorRequest() {

        // get user input
        System.out.print("Enter a color: ");
        String color = scanner.nextLine().trim();

        // perform search and display result
        displayVehicles(this.dealership.getVehiclesByColor(color));

    }

    public void processGetByMileageRequest() {

        int min;
        int max;

        // this loop will prompt for min value input until valid input is entered
        while (true) {
            try {
                System.out.print("Enter a min value: ");
                min = Integer.parseInt(scanner.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Only numbers are allowed.");
            }
        }

        // this loop will prompt for max value input until valid input is entered
        while (true) {
            try {
                System.out.print("Enter a max value: ");
                max = Integer.parseInt(scanner.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Only numbers are allowed.");
            }
        }

        // perform search and display result
        displayVehicles(this.dealership.getVehiclesByMileage(min, max));

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
