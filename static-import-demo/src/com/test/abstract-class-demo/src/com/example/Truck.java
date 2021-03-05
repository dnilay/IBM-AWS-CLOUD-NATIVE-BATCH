package com.example;

public class Truck extends Vehicle{

    private double maxLoad;

    public Truck(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    @Override
    public double calculateFuelEfficiency() {


        return 0;
    }

    @Override
    public double calculateTripDistance() {
        return 0;
    }

    @Override
    public void display() {
        super.display();
    }
}
