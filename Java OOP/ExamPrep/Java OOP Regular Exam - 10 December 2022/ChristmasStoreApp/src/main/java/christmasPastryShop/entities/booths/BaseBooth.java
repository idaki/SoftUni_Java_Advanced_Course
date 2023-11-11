package christmasPastryShop.entities.booths;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<christmasPastryShop.entities.cocktails.interfaces.Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth( int boothNumber, int capacity, double pricePerPerson) {
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;

    }

    protected void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    protected void setReserved(boolean reserved) {
        this.isReserved = reserved;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    protected void calculatePrice() {
        double price = this.pricePerPerson * this.numberOfPeople;
        this.setPrice(price);
    }

    //todo possible logic flow

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        if (this.capacity >= this.numberOfPeople) {
            this.setReserved(true);
            this.calculatePrice();
        }
    }

    @Override
    public double getBill() {
        double sumCocktailsCost = cocktailOrders.stream()
                .mapToDouble(christmasPastryShop.entities.cocktails.interfaces.Cocktail::getPrice)
                .sum();
        double sumDelicaciesCost = delicacyOrders.stream()
                .mapToDouble(Delicacy::getPrice)
                .sum();

        return sumCocktailsCost+sumDelicaciesCost;
    }

    @Override
    public void clear() {
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.numberOfPeople = 0;
        this.setReserved(false);
        this.setPrice(0);
    }
}
