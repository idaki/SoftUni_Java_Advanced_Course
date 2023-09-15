package bank.entities.client;

import bank.common.ExceptionMessages;
import bank.utils.DoubleUtils;
import bank.utils.StringUtils;

public abstract class BaseClient implements Client {
    private String name;
    private String ID;
    private int interest; //client's interest
    private double income;

    protected BaseClient(String name, String ID, int interest, double income) {
        this.setName(name);
        this.setID(ID);
        this.setInterest(interest);
        this.setIncome(income);
    }

    private void setID(String ID) {
        if (StringUtils.isNullOrEmptyString(ID)) {
            throw new IllegalArgumentException(ExceptionMessages.CLIENT_ID_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.ID = ID;
    }

    protected void setInterest(int interest) {
        this.interest = interest;
    }

    private void setIncome(double income) {
        if (DoubleUtils.isNegativeOrZero(income)) {
            throw new NullPointerException(ExceptionMessages.CLIENT_INCOME_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.income = income;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (StringUtils.isNullOrEmptyString(name)) {
            throw new NullPointerException(ExceptionMessages.CLIENT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getInterest() {
        return this.interest;
    }

    @Override
    public double getIncome() {
        return this.income;
    }

    @Override
    public abstract void increase();
}
