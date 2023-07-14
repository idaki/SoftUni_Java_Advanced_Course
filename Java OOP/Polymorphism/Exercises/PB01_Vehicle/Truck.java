package PB01_Vehicle;

public class Truck extends VehicleImpl {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        super.setFuelConsumption(fuelConsumption+1.6);    }
}
