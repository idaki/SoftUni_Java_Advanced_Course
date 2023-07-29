package football.entities.player;

public class Women extends BasePlayer {
    private static final double INITIAL_KG = 60.00;
    private static final int INCREASE_FACTOR = 115;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_KG, strength);
    }

    @Override
    public void stimulation() {
        int newKG = super.getStrength() + INCREASE_FACTOR;
        super.setStrength(newKG);
    }
}
