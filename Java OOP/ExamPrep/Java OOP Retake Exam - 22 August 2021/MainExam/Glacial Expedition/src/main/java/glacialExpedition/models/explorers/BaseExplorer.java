package glacialExpedition.models.explorers;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;
import glacialExpedition.utils.DoubleUtils;
import glacialExpedition.utils.StringUtils;

import java.util.stream.Collectors;

public abstract class BaseExplorer implements Explorer {

    private static final double DECREASE_ENERGY_FACTOR = 15;
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();

    }

    private void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (DoubleUtils.isNegative(energy)) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
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
    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        double decreasedEnergy = this.energy - DECREASE_ENERGY_FACTOR;

        this.setEnergy(DoubleUtils.isNegative(decreasedEnergy)
                ? 0
                : decreasedEnergy);
    }

    @Override
    public String toString() {
        String pattern = ConstantMessages.FINAL_EXPLORER_NAME
                + System.lineSeparator()
                + ConstantMessages.FINAL_EXPLORER_ENERGY
                + System.lineSeparator()
                + ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS
                + System.lineSeparator();



        return String.format(pattern
                , this.name
                , this.energy
                , this.suitcase.getExhibits().isEmpty() ?
                        "None"
                        : String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER
                                , this.suitcase.getExhibits()))
                .trim();
    }
}
