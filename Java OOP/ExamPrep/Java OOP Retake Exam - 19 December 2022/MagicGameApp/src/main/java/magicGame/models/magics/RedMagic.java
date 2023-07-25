package magicGame.models.magics;

public class RedMagic extends MagicImpl {

    public static final int BULLETS_PER_FIRE = 1;

    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {

        boolean areBulletsEnough = super.getBulletsCount() - BULLETS_PER_FIRE >= 0;

        if (!areBulletsEnough) {
            return 0;
        } else {
            this.setBulletsCount(this.getBulletsCount() - BULLETS_PER_FIRE);
            return BULLETS_PER_FIRE;
        }
    }
}


