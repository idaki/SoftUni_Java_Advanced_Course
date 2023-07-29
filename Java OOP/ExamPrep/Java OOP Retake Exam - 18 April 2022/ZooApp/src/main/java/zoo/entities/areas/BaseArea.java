package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseArea  implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public int sumCalories() {
        return foods.stream()
                .mapToInt(Food::getCalories)
                .sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (capacity <= animals.size()) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
//        StringBuilder sb = new StringBuilder();
//        String pattern = "%s (%s):";
//        sb.append(String.format(pattern
//                        , this.name
//                        , this.getClass().getSimpleName()))
//                .append(System.lineSeparator());
//        pattern= "Animals: %s";
//        sb.append(String.format(pattern
//                ,getAnimalsAsPrintableString()))
//                .append(System.lineSeparator());
//        pattern= "Foods: %d";
//        sb.append(String.format(pattern
//                        ,this.foods.size()))
//                .append(System.lineSeparator());
//        pattern= "Calories: %d";
//        sb.append(String.format(pattern
//                        ,this.sumCalories()))
//                .append(System.lineSeparator());
//
//       return sb.toString().trim();

        StringBuilder output = new StringBuilder()
                .append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Animal: ");

        if (this.animals.isEmpty()) {
            output.append("none");
        } else {

            output.append(this.animals.stream().map(Animal::getName).collect(Collectors.joining(" ")));
        }

        output
                .append(System.lineSeparator())
                .append("Foods: ")
                .append(this.foods.size())
                .append(System.lineSeparator())
                .append("Calories: ")
                .append(this.sumCalories());

        return output.toString().trim();
    }



    private String getAnimalsAsPrintableString() {
        String result="";
        if (animals.size()==0) {
            return "none";
        } else {
            result = animals.stream()
                    .map(Animal::getName)
                    .collect(Collectors.joining(", "));
        }
        return result;
    }
}
