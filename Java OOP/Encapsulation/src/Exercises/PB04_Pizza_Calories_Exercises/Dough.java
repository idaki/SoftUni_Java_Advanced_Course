package PB04_Pizza_Calories_Exercises;

import java.util.Arrays;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!"White".equals(flourType) && !"Wholegrain".equals(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        if ("White".equals(flourType) || "Wholegrain".equals(flourType)) {
            this.flourType = flourType;
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        String[] techniqueOptions = {"Crispy", "Chewy", "Homemade"};
        if (!Arrays.asList(techniqueOptions).contains(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private double flourTypeModifier() {
        double modifier = 1;
        if ("White".equals(flourType)) {
            modifier = 1.5;
        }
        return modifier;
    }

    private double bakingTechniqueModifier() {
        double modifier = 1;

        if ("Crispy".equals(this.bakingTechnique)) {
            modifier = 0.9;
        } else if ("Chewy".equals(this.bakingTechnique)) {
            modifier = 1.1;
        }

        return modifier;
    }


    public double calculateCalories() {

        return this.weight * 2 * flourTypeModifier() * bakingTechniqueModifier();

    }

}
