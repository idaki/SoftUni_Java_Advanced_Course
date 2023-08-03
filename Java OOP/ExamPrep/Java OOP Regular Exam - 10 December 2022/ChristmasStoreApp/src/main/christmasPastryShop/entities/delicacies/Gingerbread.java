package christmasPastryShop.entities.delicacies;

public class Gingerbread extends BaseDelicacy{
    public static final double INITIAL_PORTION = 200;


    public Gingerbread(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }
}
