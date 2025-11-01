package com.pluralsight;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Dealership {

    // private attributes
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> vehicles;

    // public constructors
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
    }

    // getter methods
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // derived getters
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {

        // this returns a Vehicle list with price values within a specified range
        return (ArrayList<Vehicle>) vehicles.stream()
                .filter(v -> v.getPrice() >= min && v.getPrice() <= max)
                .collect(Collectors.toList());

    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {

        // this returns a Vehicle list with matching values for make and model
        return (ArrayList<Vehicle>) vehicles.stream()
                .filter(v -> v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());

    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {

        // this returns a Vehicle list with a year within a specified range
        return (ArrayList<Vehicle>) vehicles.stream()
                .filter(v -> v.getYear() >= min && v.getYear() <= max)
                .collect(Collectors.toList());

    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {

        // this returns a Vehicle list with matching values for color
        return (ArrayList<Vehicle>) vehicles.stream()
                .filter(v -> v.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());

    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {

        // this returns a Vehicle list with mileage values within a specified range
        return (ArrayList<Vehicle>) vehicles.stream()
                .filter(v -> v.getOdometer() >= min && v.getOdometer() <= max)
                .collect(Collectors.toList());

    }

    public Vehicle getVehicleByVin(int vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {

        // this returns a Vehicle list with matching values for vehicleType
        return (ArrayList<Vehicle>) vehicles.stream()
                .filter(v -> v.getVehicleType().equalsIgnoreCase(vehicleType))
                .collect(Collectors.toList());

    }

    public ArrayList<Vehicle> getAllVehicles() {

        return this.vehicles;

    }

    // helper methods
    public void addVehicle(Vehicle vehicle) {

        this.vehicles.add(vehicle);

    }

    public void removeVehicle(Vehicle vehicle) {

        this.vehicles.remove(vehicle);

    }

}
