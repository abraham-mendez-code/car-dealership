package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    // private attributes
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {

        return null;

    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {

        return null;

    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {

        return null;

    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {

        return null;

    }

    public ArrayList<Vehicle> getVehiclesByMilage(double min, double max) {

        return null;

    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {

        return null;

    }

    public ArrayList<Vehicle> getAllVehicles() {

        return null;

    }

    public void addVehicle(Vehicle vehicle) {



    }

    public void removeVehicle(Vehicle vehicle) {



    }

}
