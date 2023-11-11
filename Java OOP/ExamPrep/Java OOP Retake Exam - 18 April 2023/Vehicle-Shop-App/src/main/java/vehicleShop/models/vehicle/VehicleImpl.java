package vehicleShop.models.vehicle;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.utils.IntegerUtils;
import vehicleShop.utils.StringUtils;

public class VehicleImpl implements Vehicle {

    private static final int VEHICLE_STRENGTH_DECREASE_FACTOR = 5;

    private String name;
    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    private void setName(String name) {
       if (StringUtils.isNullOrEmptyString(name)) {
           throw new IllegalArgumentException(ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY);
       }
        this.name = name;
    }

    private void setStrengthRequired(int strengthRequired) {
        if (IntegerUtils.isNegativeNumber(strengthRequired)){
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthRequired() {
        return this.strengthRequired;
    }

    @Override
    public boolean reached() {
        return this.strengthRequired == 0;
    }

    @Override
    public void making() {
        int newStrengthRequired = this.strengthRequired - VEHICLE_STRENGTH_DECREASE_FACTOR;
        if (newStrengthRequired<0){
            newStrengthRequired =0;
        }
        this.setStrengthRequired(newStrengthRequired);
    }
}
