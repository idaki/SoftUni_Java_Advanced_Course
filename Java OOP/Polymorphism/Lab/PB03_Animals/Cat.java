package PB03_Animals;

public class Cat extends Animal {
    private static final String SOUND = "MEEOW";

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        String pattern = "I am %s and my favourite food is %s %s";

        return String.format(pattern, super.getName(), super.getFavouriteFood(), this.SOUND);
    }
}
