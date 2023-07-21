package PB02_Animal_Farm_Exercise;

import java.text.DecimalFormat;

public class Chicken {
    private static final DecimalFormat df = new DecimalFormat("0.##");

    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.\"");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay() {
        double products = 0.0;
        if (age < 6) {
            products = 2;
        } else if (age < 12) {
            products = 1;
        } else {
            products = 0.75;
        }
        return products;
    }

    public double productPerDay(){
       return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                this.name, this.age, df.format(this.productPerDay()));
    }

}
