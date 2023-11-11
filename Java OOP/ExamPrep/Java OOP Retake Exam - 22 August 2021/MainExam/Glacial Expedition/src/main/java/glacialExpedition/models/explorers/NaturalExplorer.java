package glacialExpedition.models.explorers;

import glacialExpedition.utils.DoubleUtils;

public class NaturalExplorer extends BaseExplorer{
    private static final double DECREASE_ENERGY_FACTOR = 7;
    private static final double INITIAL_ENERGY = 60; //was 60


    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }


    @Override
    public void search() {
        double decreasedEnergy = super.getEnergy() - DECREASE_ENERGY_FACTOR;

        this.setEnergy(DoubleUtils.isNegative(decreasedEnergy)
                ? 0
                : decreasedEnergy);
    }
}
