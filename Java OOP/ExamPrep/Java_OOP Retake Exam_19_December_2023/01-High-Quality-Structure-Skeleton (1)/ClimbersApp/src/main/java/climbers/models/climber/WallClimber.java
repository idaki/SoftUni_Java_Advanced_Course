package climbers.models.climber;

public class WallClimber extends BaseClimber {

    public static final double INITIAL_STRENGTH = 90;
    public static final double DECREASE_STRENGTH = 30;

    public WallClimber(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void climb() {
        double newStrength = super.getStrength() - DECREASE_STRENGTH;

        if (newStrength < 0) {
            newStrength = 0;
        }
        super.setStrength(newStrength);

    }
}
