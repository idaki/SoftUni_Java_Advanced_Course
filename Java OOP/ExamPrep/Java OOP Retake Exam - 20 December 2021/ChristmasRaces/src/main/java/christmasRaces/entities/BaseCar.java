package christmasRaces.entities;

public class BaseCar implements Car {
    private String model;
    private int horsePower;
    private double cubicCentimeters;


    @Override
    public String getModel() {
        return null;
    }

    @Override
    public int getHorsePower() {
        return 0;
    }

    @Override
    public double getCubicCentimeters() {
        return 0;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return 0;
    }
}
