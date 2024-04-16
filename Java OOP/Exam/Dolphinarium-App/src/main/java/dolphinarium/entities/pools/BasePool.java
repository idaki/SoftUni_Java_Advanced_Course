package dolphinarium.entities.pools;

import dolphinarium.common.ExceptionMessages;
import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.foods.Food;
import dolphinarium.utils.IntegerUtils;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;

public abstract class BasePool implements Pool {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Dolphin> dolphins;

    public BasePool(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.dolphins = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFoods(Collection<Food> foods) {
        this.foods = foods;
    }

    public void setDolphins(Collection<Dolphin> dolphins) {
        this.dolphins = dolphins;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public Collection<Dolphin> getDolphins() {
        return this.dolphins;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public void addDolphin(Dolphin dolphin) {
        if (this.capacity <= dolphins.size()) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        if (IntegerUtils.isSmallerOrEqualToZero(dolphin.getEnergy())) {
            throw new IllegalArgumentException(ExceptionMessages.DOLPHIN_ENERGY_BELOW_OR_EQUAL_ZERO);
        }
        this.dolphins.add(dolphin);

    }

    @Override
    public void removeDolphin(Dolphin dolphin) {
        this.dolphins.remove(dolphin);
    }


}
