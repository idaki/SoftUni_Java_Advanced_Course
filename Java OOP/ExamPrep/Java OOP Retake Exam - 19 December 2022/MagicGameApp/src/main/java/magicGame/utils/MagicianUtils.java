package magicGame.utils;

import magicGame.models.magics.Magic;

public final class MagicianUtils {
    private MagicianUtils() {
    }

    public static boolean isMagicianTypeValid(String type) {
        return "Wizard".equals(type) || "BlackWidow".equals(type);
    }
}
