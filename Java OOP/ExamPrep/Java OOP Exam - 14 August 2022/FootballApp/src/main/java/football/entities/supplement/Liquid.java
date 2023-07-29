package football.entities.supplement;

public class Liquid extends BaseSupplement {
    private static final int INITIAL_ENERGY = 90;
    private static final double PRICE = 25;


    public Liquid() {
        super(INITIAL_ENERGY, PRICE);
    }
}
