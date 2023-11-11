package fairyShop.models;

import fairyShop.common.ExceptionMessages;
import fairyShop.utils.IntegerUtils;

public class InstrumentImpl implements Instrument {
    private static final int DECREASE_POWER_FACTOR = 10;
    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    private void setPower(int power) {
        if (IntegerUtils.isSmallerThanZero(power)) {
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        int newPower = this.power - DECREASE_POWER_FACTOR;
        if (newPower < 0) {
            newPower = 0;
        }
        this.setPower(newPower);
    }

    @Override
    public boolean isBroken() {
        return this.power == 0;
    }
}
