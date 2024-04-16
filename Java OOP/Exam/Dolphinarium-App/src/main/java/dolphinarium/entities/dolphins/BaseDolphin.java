package dolphinarium.entities.dolphins;

import dolphinarium.common.ExceptionMessages;
import dolphinarium.entities.foods.Food;
import dolphinarium.utils.StringUtils;

public abstract class BaseDolphin implements Dolphin {

    private String name;
    private int energy;

    public BaseDolphin(String name, int energy) {
        this.setName(name);
        this.setEnergy(energy);
    }

    public void setName(String name) {
       if( StringUtils.isNullOrEmpty(name)){
           throw new NullPointerException(ExceptionMessages.DOLPHIN_NAME_NULL_OR_EMPTY);
       }
        this.name = name;
    }

    public void setEnergy(int energy) {
        if(energy<0){
            energy=0;
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

}
