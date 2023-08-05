package magicGame.models.magics;

public class BlackMagic extends MagicImpl {

    public static final int BULLETS_PER_FIRE = 10;

    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    private int bullets = getBulletsCount();

    @Override
    public int fire() {
        if (bullets - BULLETS_PER_FIRE < 0) {
            bullets = 0;
            return 0;
        } else {
            bullets -= BULLETS_PER_FIRE;
            return BULLETS_PER_FIRE;
        }
    }
}


