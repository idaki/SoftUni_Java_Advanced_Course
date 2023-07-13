package PB02_Car_Shop_Extend.Class;

import PB02_Car_Shop_Extend.Interface.Rentable;

public class Audi extends CarImpl implements Rentable {
 private int minRentDay;
 private double pricePerDay;

    public Audi(String model,
                String color,
                Integer horsePower,
                String countryProduced,
                int minRentDay,
                double pricePerDay  ) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        String pattern = "Minimum rental period of %d days. Price per day %f";
        return String.format(pattern, this.getMinRentDay(),this.getPricePerDay());
    }
}
