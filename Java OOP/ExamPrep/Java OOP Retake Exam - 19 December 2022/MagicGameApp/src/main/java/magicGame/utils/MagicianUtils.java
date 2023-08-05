package magicGame.utils;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.MagicianImpl;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.Magic;

import java.util.List;

public final class MagicianUtils {
    private MagicianUtils() {
    }

    public static boolean isMagicianTypeValid(String type) {
        return "Wizard".equals(type) || "BlackWidow".equals(type);
    }

    public static boolean hasAliveWizards(List<Magician> wizards){
        return wizards.stream().filter(Magician::isAlive).iterator().hasNext();
    }
    public static boolean hasAliveBlackWidows(List<Magician> blackWidows){
        return blackWidows.stream().filter(Magician::isAlive).iterator().hasNext();
    }

    public static Magician getNextAliveWizard(List<Magician> wizards){
        return wizards.stream().filter(Magician::isAlive).iterator().next();
    }
    public static Magician getNextAliveBlackWidows(List<Magician> blackWidows){
        return blackWidows.stream().filter(Magician::isAlive).iterator().next();
    }
}
