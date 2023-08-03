package vehicleShop.utils;

public final class StringUtils {
    private StringUtils() {
    }

    public static boolean isNullOrEmptyString(String input){
        return input == null || input.equals("");
    }
}
