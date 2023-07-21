package PB04_Need_For_Speed.Vehicle.Car.SportCar;

import PB04_Need_For_Speed.Vehicle.Car.Car;

public class SportCar extends Car {

    private final static double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
