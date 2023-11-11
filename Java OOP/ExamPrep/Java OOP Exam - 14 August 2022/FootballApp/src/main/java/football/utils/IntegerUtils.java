package football.utils;

public final class IntegerUtils {

    private IntegerUtils() {
    }

    public static boolean isSmallerOrEqualToZero(int input) {
        return (input <= 0);
    }
    public static boolean isCapacityAvailable(int input, int capacity) {
        return (input < capacity);
    }

}
