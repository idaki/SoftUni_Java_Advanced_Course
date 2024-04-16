package dolphinarium.entities.dolphins;

import dolphinarium.entities.foods.Food;

public class BottleNoseDolphin extends BaseDolphin {
    private final int SQUID_FOOD_INCREASE_AMOUNT = 175;
    private final int HERRING_FOOD_INCREASE_AMOUNT = 200;
    private final int MACKEREL_FOOD_INCREASE_AMOUNT = 305;
    private final static int ENERGY_DECREASE_FACTOR = 10 + 190;



    public BottleNoseDolphin(String name, int energy) {
        super(name, energy);

    }

    @Override
    public void jump() {
        int energy= super.getEnergy();
        energy-=ENERGY_DECREASE_FACTOR;
        super.setEnergy(energy);
    }

    @Override
    public void eat(Food food) {
        String foodType = food.getClass().getSimpleName();
        int energy= super.getEnergy();

        if (foodType.equals("Squid")){
           energy+=SQUID_FOOD_INCREASE_AMOUNT;

        }else if (foodType.equals("Herring")){
           energy+=HERRING_FOOD_INCREASE_AMOUNT;
        } else if (foodType.equals("Mackerel")) {
            energy +=MACKEREL_FOOD_INCREASE_AMOUNT;
        }
        super.setEnergy(energy);


    }
}
