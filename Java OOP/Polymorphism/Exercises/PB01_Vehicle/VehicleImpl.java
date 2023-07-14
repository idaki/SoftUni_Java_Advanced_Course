package PB01_Vehicle;

import java.text.DecimalFormat;

public class VehicleImpl implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    public VehicleImpl(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(double distance) {
        double requiredFuel = this.fuelConsumption * distance;

        DecimalFormat df = new DecimalFormat("#.##");

        String result = String.format("%s needs refueling", this.getClass().getSimpleName());

        if (this.fuelQuantity >= requiredFuel) {
            result = String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),
                    df.format(distance));

            this.fuelQuantity -= requiredFuel;
        }

        return result;
    }

    @Override
    public void refuel(double liters) {
        if (this.getClass().getSimpleName().equals("Truck")) {
            liters *= 0.95;
        }
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}