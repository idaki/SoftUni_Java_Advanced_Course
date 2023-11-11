package PB04_Pizza_Calories_Exercises;

import java.util.Arrays;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        String[] toppingTypesOptions = {"Meat", "Veggies", "Cheese", "Sauce"};
        if (!Arrays.asList(toppingTypesOptions).contains(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {

        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }


    public double calculateCalories() {

        double modifier = 0;
        if ("Meat".equals(this.toppingType)) {
            modifier = 1.2;
        } else if ("Veggies".equals(this.toppingType)) {
            modifier = 0.8;
        } else if ("Cheese".equals(this.toppingType)) {
            modifier = 1.1;
        } else if ("Sauce".equals(this.toppingType)) {
            modifier = 0.9;
        }
        return modifier * weight * 2;
    }
}
