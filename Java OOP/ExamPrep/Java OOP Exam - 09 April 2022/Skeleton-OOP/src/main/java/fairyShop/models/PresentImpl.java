package fairyShop.models;

import fairyShop.common.ExceptionMessages;
import fairyShop.utils.IntegerUtils;
import fairyShop.utils.StringUtils;

public class PresentImpl implements Present {

    private static final int DECREASE_REQUIRED_ENERGY_FACTOR = 10;
    private String name;
    private int energyRequired; //	The energy a present requires in order to be crafted.

    public PresentImpl(String name, int energyRequired) {
        this.setName(name);
        this.setEnergyRequired(energyRequired);
    }

    private void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new NullPointerException(ExceptionMessages.PRESENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergyRequired(int energyRequired) {
        if (IntegerUtils.isSmallerThanZero(energyRequired)) {
            throw new IllegalArgumentException(ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO);
        }
        this.energyRequired = energyRequired;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergyRequired() {

        return this.energyRequired;
    }

    @Override
    public boolean isDone() {
        return this.energyRequired == 0;
    }

    @Override
    public void getCrafted() {
        int newEnergy = this.energyRequired - DECREASE_REQUIRED_ENERGY_FACTOR;
        if (newEnergy < 0) {
            newEnergy = 0;
        }
        this.setEnergyRequired(newEnergy);
    }
}
