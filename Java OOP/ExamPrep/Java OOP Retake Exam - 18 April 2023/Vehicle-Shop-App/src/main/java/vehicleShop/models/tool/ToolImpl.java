package vehicleShop.models.tool;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.utils.IntegerUtils;

public class ToolImpl implements Tool {

    private static final int POWER_DECREASE_FACTOR = 5;
    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }

    private void setPower(int power) {
        if (IntegerUtils.isNegativeNumber(power)) {
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void decreasesPower() {
        int newPower = this.power - POWER_DECREASE_FACTOR;
        if (newPower < 0) {
            newPower = 0;
        }
        this.setPower(newPower);

    }

    @Override
    public boolean isUnfit() {
        return this.power == 0;
    }
}
