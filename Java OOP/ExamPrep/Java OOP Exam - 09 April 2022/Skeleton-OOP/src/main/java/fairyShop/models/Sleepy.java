package fairyShop.models;

public class Sleepy extends BaseHelper {

    private static final int ENERGY_DECREASE_FACTOR = 15;
    private static final int INITIAL_ENERGY = 50;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }


    @Override
    public void work() {
        int newEnergy = super.getEnergy() - ENERGY_DECREASE_FACTOR;
        if (newEnergy < 0) {
            newEnergy = 0;
        }
        super.setEnergy(newEnergy);
    }
}
