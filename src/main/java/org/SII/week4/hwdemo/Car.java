package org.SII.week4.hwdemo;


import org.SII.week4.hwdemo.enums.FuelType;

public abstract class Car implements Vehicle {
    final double fuelTankSize;
    final FuelType fuelType;
    final int gears;
    final double consumption;

    double availableFuel;
    int tireSize;
    String vin;

    int currentGear = 0;
    double gearBonus = 0.9;

    public Car(double fuelTankSize, FuelType fuelType, int gears, double consumption,
               double availableFuel, int tireSize, String vin) {
        this.fuelTankSize = fuelTankSize;
        this.fuelType = fuelType;
        this.gears = gears;
        this.consumption = consumption;
        this.availableFuel = availableFuel;
        this.tireSize = tireSize;
        this.vin = vin;
    }

    public double getAvailableFuel() {
        return availableFuel;
    }

    public void setAvailableFuel(double availableFuel) {
        this.availableFuel = availableFuel;
    }

    public int getTireSize() {
        return tireSize;
    }

    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }

    /**
     * @return consumption * (bonus)^(currentGear-1)
     */
    double getCurrentConsumption() {
        if (currentGear == 0) {
            return consumption;
        }
        return consumption * Math.pow(gearBonus, currentGear - 1);
    }

    @Override
    public void drive(double distance) {
        if (currentGear == 0) {
            return;
        }
        double usedFuel = (getCurrentConsumption() / 100) * distance;

        if (availableFuel < usedFuel) {
            availableFuel = 0;
            stop();
            return;
        }

        availableFuel -= usedFuel;
    }

    @Override
    public void stop() {
        currentGear = 0;
    }

    @Override
    public void start() {
        currentGear = 1;
    }

    public void shiftGear(int gear) {
        currentGear = gear;
    }

}
