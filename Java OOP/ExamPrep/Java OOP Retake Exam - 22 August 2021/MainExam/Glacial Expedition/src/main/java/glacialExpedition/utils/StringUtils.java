package glacialExpedition.utils;

import java.util.ArrayList;
import java.util.Collection;

public final class StringUtils {
    private StringUtils() {
    }

    public static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }


    public static Collection<String> collectInputInCollection(String... input) {
        Collection<String> output = new ArrayList<>();
        for (String i : input) {
            output.add(i);
        }
        return output;
    }
}
