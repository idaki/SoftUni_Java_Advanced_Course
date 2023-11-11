package football.utils;

import football.common.ExceptionMessages;

public final class StringUtils {
    private StringUtils() {
    }

    public  static  boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isFieldTypeValid(String type){

        return "ArtificialTurf".equals(type) || "NaturalGrass".equals(type);

    }

    public static boolean isSupplementTypeValidForDelivery(String type){

        return "Powdered".equals(type) || "Liquid".equals(type);
    }
    public static boolean isPlayerTypeValid(String type){

        return "Men".equals(type) || "Women".equals(type);
    }


}
