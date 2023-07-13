package PB02_Car_Shop_Extend.Class;

import PB02_Car_Shop_Extend.Interface.Sellable;

public class Seat extends CarImpl implements Sellable {

    private double price;

    public Seat(String model,
                String color,
                Integer horsePower,
                String countryProduced,
                double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }


    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String pattern = "Leon sells for %f";
        return String.format(pattern, this.getPrice());
    }
}
