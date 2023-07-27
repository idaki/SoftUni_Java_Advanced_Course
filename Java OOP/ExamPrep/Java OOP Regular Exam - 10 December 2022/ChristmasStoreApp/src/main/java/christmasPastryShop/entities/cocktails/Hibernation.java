package christmasPastryShop.entities.cocktails;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

public class Hibernation extends BaseCocktail {
    public static final double PRICE = 4.50;
    public Hibernation(String name, int size, String brand) {
        super(name, size, PRICE, brand);
    }
}
