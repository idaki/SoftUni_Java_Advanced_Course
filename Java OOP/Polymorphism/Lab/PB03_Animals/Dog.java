package PB03_Animals;

public class Dog extends Animal {
    private static final String SOUND = "DJAAF";

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        String pattern = "I am %s and my favourite food is %s %s";

        return String.format(pattern, super.getName(), super.getFavouriteFood(), this.SOUND);
    }
}
