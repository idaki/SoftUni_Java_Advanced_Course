package fairyShop.models;

import fairyShop.common.ExceptionMessages;
import fairyShop.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHelper implements Helper {

    private static final int ENERGY_DECREASE_FACTOR = 10;
    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    protected BaseHelper(String name, int energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    private void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new NullPointerException(ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }
//todo check logic
    @Override
    public abstract void work();

    @Override
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }
}
