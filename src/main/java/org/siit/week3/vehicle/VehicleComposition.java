package org.siit.week3.vehicle;


import org.siit.week3.vehicle.engine.Engine;

import java.awt.*;

public class VehicleComposition {
    private double fuelLevel = 5;
    private int gear = 0;
    private double speed = 0;
    private Color color = Color.gray;
    private String brand;
    private Engine engine;
    private int wheels = 4;

    public VehicleComposition() {
    }

    public VehicleComposition(Color color) {
        this.color = color;
    }

    /**
     * @param fuelLevel the fuel level for the new car
     * @param color     color of the car
     */
    public VehicleComposition(double fuelLevel, Color color) {
        this(color);
//        this.color = color;
        this.fuelLevel = fuelLevel;
    }

    public VehicleComposition(double fuelLevel, Color color, Engine engine) {
        this(fuelLevel, color);
        this.engine = engine;
        this.start();
    }

    /**
     * Starts the car
     */
    public void start() {
        initialChecks();
        this.engine.startEngine();
        this.gear = 1;
        this.speed = 7;
        System.out.println("ro.sci.vehicle.Vehicle started");
    }

    private void initialChecks() {
        System.out.println("Initial checks");
    }

    public void stop() {
        System.out.println("ro.sci.vehicle.Vehicle stopped");
    }

    public double faster() {
        this.speed += 10;
        return this.speed;
    }

    public double slower() {
        if (this.speed > 10) {
            this.speed -= 10;
        } else {
            this.speed = 0;
        }
        return this.speed;

//        speed > 10 ? speed -= 10 : speed = 0;
//        return speed;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public double getSpeed() {
        return speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ro.sci.vehicle.Vehicle{" +
                "fuelLevel=" + fuelLevel +
                ", gear=" + gear +
                ", speed=" + speed +
                ", color=" + color +
                ", brand='" + brand + '\'' +
                ", engine=" + engine +
                '}';
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
