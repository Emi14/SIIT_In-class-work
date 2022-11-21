package org.SII.week4.hwdemo;


import org.SII.week4.hwdemo.enums.FuelType;

public class Dacia extends Car {

    public Dacia(double availableFuel, String vin) {
        super(50, FuelType.GAS, 6, 5, availableFuel, 15, vin);
    }

}
