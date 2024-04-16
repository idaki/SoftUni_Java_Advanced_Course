package dolphinarium.entities.pools;

import dolphinarium.entities.foods.Food;

import java.util.Collection;

public class ShallowWaterPool extends BasePool {
    private final static int CAPACITY = 2;
    public ShallowWaterPool(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addFood(Food food) {
        Collection<Food> currentFood = super.getFoods();
        if(CAPACITY>currentFood.size()){
            super.getFoods().add(food);
        }
    }
}
