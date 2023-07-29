package football.utils;

import football.entities.field.Field;
import football.entities.player.Player;

public final class PlayerUtils {
    private PlayerUtils() {
    }

    public static boolean canPlayerJoinField(String playerType, Field field){

        String fieldType = field.getClass().getSimpleName();  // ArtificialTurf or natural grass
        //woman ->ArtificialTurf
        //man ->NaturalGrass

        return ("Women".equals(playerType)&& "ArtificialTurf".equals(fieldType))
                || ("Men".equals(playerType)&& "NaturalGrass".equals(fieldType));

    }
}
