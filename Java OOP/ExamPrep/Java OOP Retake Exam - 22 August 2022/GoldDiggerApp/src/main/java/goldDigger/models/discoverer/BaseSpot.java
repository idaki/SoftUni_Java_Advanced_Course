package goldDigger.models.discoverer;

import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseSpot implements Discoverer {
    private String name;
    private double energy;
    private Museum museum;

    public BaseSpot(String name, double energy) {
        this.setName( name);
        this.setEnergy(energy);
        museum = new BaseMuseum();
    }

    protected void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canDig() {
        if (this.energy > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }
//todo later discoverers might implement differently
    @Override
    public void dig() {
       double newEnergy = this.energy-15;

       if (newEnergy <0){
           newEnergy = 0;
       }
       this.setEnergy(newEnergy);
    }
}
