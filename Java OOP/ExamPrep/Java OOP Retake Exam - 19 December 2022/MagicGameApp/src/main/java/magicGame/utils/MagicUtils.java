package magicGame.utils;

import magicGame.models.magicians.Magician;
import magicGame.repositories.interfaces.MagicRepository;

public final class MagicUtils {
    private MagicUtils() {
    }

    public static boolean isMagicValid(String type){
        return "RedMagic".equals(type) || "BlackMagic".equals(type);
    }

    public static boolean areBulletsEnough(Magician magician){
        String magicType= magician.getMagic().getName();
        int bulletCount = magician.getMagic().getBulletsCount();


        return ("BlackMagic".equals(magicType)&&bulletCount>=10) || ("RedMagic".equals(magicType)&&bulletCount>=1);
    }


}
