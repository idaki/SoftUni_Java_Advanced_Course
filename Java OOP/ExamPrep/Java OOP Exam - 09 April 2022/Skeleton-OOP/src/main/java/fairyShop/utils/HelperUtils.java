package fairyShop.utils;

import fairyShop.models.Happy;
import fairyShop.models.Helper;
import fairyShop.models.Instrument;
import fairyShop.models.Sleepy;

import java.util.Collection;

public abstract class HelperUtils {
    private HelperUtils() {
    }

    public static boolean isHelperTypeValidToCreate(String type) {
        return "Happy".equals(type) || "Sleepy".equals(type);
    }

    public static Helper createNewHelper(String type, String name) {
        Helper helper = null;
        if ("Happy".equals(type)) {
            helper = new Happy(name);
        } else if ("Sleepy".equals(type)) {
            helper = new Sleepy(name);
        }
        return helper;
    }

    public static boolean helperIsExisting(Helper helper) {
        return helper != null;
    }

    public static boolean isHelperReadyToStarWorking(Helper helper) {
        return helper != null;
    }

    public static String getHelperInfo(Helper helper){
        String name = helper.getName();
        int energy = helper.getEnergy();

        long countNotBrokenInstruments = helper.getInstruments().stream()
                .map(Instrument::isBroken)
                .filter(broken ->!broken).count();

        String pattern = "Name: %s"
                        +System.lineSeparator()
                        +"Energy: %d"
                        +System.lineSeparator()
                        +"Instruments: %d not broken left"
                        +System.lineSeparator();

        return  String.format(pattern,
                name
                ,energy
                ,countNotBrokenInstruments);

    }
}


