package football.entities.player;

import football.common.ExceptionMessages;
import football.utils.IntegerUtils;
import football.utils.StringUtils;

public abstract class BasePlayer implements Player {

    private String name;
    private String nationality;
    private double kg;
    private int strength;

    protected BasePlayer(String name, String nationality, double kg, int strength) {
        this.setName(name);
        this.setNationality(nationality);
        this.setKg(kg);
        this.setStrength(strength);
    }

    @Override
    public void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setNationality(String nationality) {
        if (StringUtils.isNullOrEmpty(nationality)) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }
        this.nationality = nationality;
    }

    private void setKg(double kg) {
        this.kg = kg;
    }

    protected void setStrength(int strength) {
        if (IntegerUtils.isSmallerOrEqualToZero(strength)) {
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public abstract void stimulation();

    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }
}
