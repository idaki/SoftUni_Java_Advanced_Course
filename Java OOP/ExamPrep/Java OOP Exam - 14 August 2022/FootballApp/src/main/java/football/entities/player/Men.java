package football.entities.player;

public class Men extends BasePlayer {
    private static final double INITIAL_KG = 85.50;
    private static final int INCREASE_FACTOR = 145;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_KG, strength);
    }

    @Override
    public void stimulation() {
        int newKG = super.getStrength() + INCREASE_FACTOR;
        super.setStrength(newKG);
    }
}
