package PB03_Speed_Racing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumption;
    private int distance;


    public Car(String model, double fuelAmount, double fuelConsumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumption = fuelConsumption;
        this.distance = 0;
    }

    public boolean drive(double distance) {
        double needFuel = distance * this.fuelConsumption;
        if (needFuel <= this.fuelAmount) {
            this.fuelAmount -= needFuel;
            this.distance += distance;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %d",model,fuelAmount,distance);
    }
}
