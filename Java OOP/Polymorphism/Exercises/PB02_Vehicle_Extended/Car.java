package PB02_Vehicle_Extended;

public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(fuelConsumption + 0.9);

    }


}
