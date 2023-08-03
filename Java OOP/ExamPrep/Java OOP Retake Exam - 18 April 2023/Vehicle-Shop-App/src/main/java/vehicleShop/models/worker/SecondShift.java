package vehicleShop.models.worker;

public class SecondShift extends BaseWorker{
    private static final int INITIAL_STRENGTH = 70;
    private static final int WORKER_STRENGTH_DECREASE_FACTOR = 15;
    public SecondShift(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void working() {

        int newStrength = super.getStrength()- WORKER_STRENGTH_DECREASE_FACTOR;
        if (newStrength < 0) {
            newStrength = 0;
        }
        super.setStrength(newStrength);

    }
}
