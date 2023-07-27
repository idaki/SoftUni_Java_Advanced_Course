package christmasPastryShop.entities.delicacies;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

public class BaseDelicacy implements Delicacy{

    private String name;
    private double portion;
    private double price;

    public  BaseDelicacy(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    protected void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }
        this.portion = portion;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    //todo maybe need to apply other formatting for the price
    @Override
    public String toString() {
        String pattern = "%s: .%2fg - %.2f";
        return String.format(pattern
                , this.name
                , this.portion
                , this.price);
    }
}
