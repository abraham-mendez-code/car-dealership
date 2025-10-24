package com.pluralsight;

public class Vehicle {

    // private attributes
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vechicleType;
    private String color;
    private int odometer;
    private double price;

    // constructors
    public Vehicle(int vin, int year, String make, String model, String vechicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vechicleType = vechicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

}
