package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if ("WaterArea".equals(areaType)) {
            area = new WaterArea(areaName);
        } else if ("LandArea".equals(areaType)) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }
        areas.add(area);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if ("Meat".equals(foodType)) {
            food = new Meat();
        } else if ("Vegetable".equals(foodType)) {
            food = new Vegetable();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }


    @Override
    public String foodForArea(String areaName, String foodType) {
        Food foodFromRepo = foodRepository.findByType(foodType);
        Area area = areas.stream()
                .filter(a -> a.getName()
                        .equals(areaName))
                .findFirst()
                .orElse(null);

        if (foodFromRepo == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        area.addFood(foodFromRepo);
        foodRepository.remove(foodFromRepo);


        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA
                , foodType
                , areaName);
    }


    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        if ("AquaticAnimal".equals(animalType)) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else if ("TerrestrialAnimal".equals(animalType)) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }

        Area area = areas.stream()
                .filter(a -> a.getName()
                        .equals(areaName))
                .findFirst()
                .orElse(null);

        String outputMessage = "";
        String areaType = area.getClass().getSimpleName();


        if ("AquaticAnimal".equals(animalType) && "WaterArea".equals(areaType)) {
            area.addAnimal(animal);

        } else if ("TerrestrialAnimal".equals(animalType) && "LandArea".equals(areaType)) {
            area.addAnimal(animal);

        } else {
            return ConstantMessages.AREA_NOT_SUITABLE;
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }


    @Override
    public String feedAnimal(String areaName) {
        Area area = areas.stream()
                .filter(a -> a.getName()
                        .equals(areaName))
                .findFirst()
                .orElse(null);
        if (area != null) {
            area.feed();
        }
        return String.format(ConstantMessages.ANIMALS_FED
                , area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = areas.stream()
                .filter(a -> a.getName()
                        .equals(areaName))
                .findFirst()
                .orElse(null);
        double sum = 0;
        if (area != null) {
            sum = area.getAnimals().stream()
                    .mapToDouble(Animal::getKg)
                    .sum();
        }

        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Area area : areas) {
            sb.append(area.getInfo()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}

