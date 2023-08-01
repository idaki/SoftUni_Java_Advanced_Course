package fairyShop.models;

public class Happy extends BaseHelper {

    private static final int ENERGY_DECREASE_FACTOR = 10;
    private static final int INITIAL_ENERGY = 100;

    public Happy(String name) {
        super(name, INITIAL_ENERGY);
    }


    @Override
    public void work() {
        int newEnergy = super.getEnergy() - ENERGY_DECREASE_FACTOR;
        if (newEnergy < 0) {
            newEnergy = 0;
        }
        this.setEnergy(newEnergy);
    }
}
