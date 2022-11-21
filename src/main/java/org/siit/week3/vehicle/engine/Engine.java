package org.siit.week3.vehicle.engine;

public class Engine {
    String fuelType;
    int cc;
    int noOfCylinders;

    public Engine(String fuelType, int cc, int noOfCylinders) {
        this.fuelType = fuelType;
        this.cc = cc;
        this.noOfCylinders = noOfCylinders;
    }

    @Override
    public String toString() {
        return "ro.sci.vehicle.engine.Engine{" +
                "fuelType='" + fuelType + '\'' +
                ", cc=" + cc +
                ", noOfCylinders=" + noOfCylinders +
                '}';
    }

    public void startEngine() {
        System.out.println("Engine started");
    }
}
