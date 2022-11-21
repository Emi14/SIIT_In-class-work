package org.siit.week3.vehicle;


import org.siit.week3.vehicle.engine.DieselEngine;

import java.awt.*;

public class VehicleInheritance extends DieselEngine {
    private double fuelLevel = 5;
    private int gear = 0;
    private double speed = 0;
    private Color color = Color.gray;
    private String brand;
    private int wheels = 4;

    public VehicleInheritance(String fuelType, int cc, int noOfCylinders) {
        super(cc, noOfCylinders);
    }
}
