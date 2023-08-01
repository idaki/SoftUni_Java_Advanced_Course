package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.utils.HelperUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private int countDonePresents;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        countDonePresents = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {


        if (!HelperUtils.isHelperTypeValidToCreate(type)) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        Helper helper = HelperUtils.createNewHelper(type, helperName);

        helperRepository.add(helper);

        return String.format(ConstantMessages.ADDED_HELPER
                , type
                , helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Instrument instrument = new InstrumentImpl(power);
        Helper helper = helperRepository.findByName(helperName);
        if (!HelperUtils.helperIsExisting(helper)) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        helper.addInstrument(instrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER
                , power
                , helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> helpers = helperRepository.getModels().stream().filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());
        if (helpers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        Present present = presentRepository.findByName(presentName);
        Shop shop = new ShopImpl();
        int brokenInstruments = 0;

        while (!helpers.isEmpty()&& !present.isDone()){
            Helper helper = helpers.get(0);
            shop.craft(present,helper);
            brokenInstruments +=helper.getInstruments().stream().filter(Instrument::isBroken).count();
            if (!helper.canWork()|| helper.getInstruments().stream().noneMatch(t->!t.isBroken())){
                helpers.remove(helper);
            }

        }

        if (present.isDone()) {
            return String.format(ConstantMessages.PRESENT_DONE, presentName, "done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
        }
        return String.format(ConstantMessages.PRESENT_DONE, presentName, "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);


        //
        //
        //
        //        Shop shop = new ShopImpl(); //магазин -> making
        //        int brokenTools = 0; //счупени инструменти
        //        while (!availableWorkers.isEmpty() && !vehicle.reached()) {
        //            Worker worker = availableWorkers.get(0);
        //            shop.make(vehicle, worker);
        //            brokenTools += worker.getTools().stream().filter(Tool::isUnfit).count();
        //
        //            if (!worker.canWork() || worker.getTools().stream().noneMatch(t -> !t.isUnfit())) {
        //                //не може да работи -> или няма сила, или няма инструменти
        //                availableWorkers.remove(worker);
        //            }
        //        }
        //
        //        //или са свършили работниците, или колата е готова
        //        if (vehicle.reached()) {
        //            //готова кола
        //            countMadeVehicle++;
        //            return String.format(ConstantMessages.VEHICLE_DONE, vehicle.getName(), "done")
        //                    + String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenTools);
        //        } else {
        //            //колата не е завършена
        //            return String.format(ConstantMessages.VEHICLE_DONE, vehicle, "not done")
        //                    + String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenTools);
        //        }
    }








    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        String patternTitle = "%d presents are done!"
                + System.lineSeparator()
                + "Helpers info:"
                + System.lineSeparator();

        String title = String.format(patternTitle, countDonePresents);
        sb.append(title);


        for (Helper helper : helperRepository.getModels()) {
            String helperPrintInfo = HelperUtils.getHelperInfo(helper);
            sb.append(helperPrintInfo);
        }

        return sb.toString().trim();
    }
}
