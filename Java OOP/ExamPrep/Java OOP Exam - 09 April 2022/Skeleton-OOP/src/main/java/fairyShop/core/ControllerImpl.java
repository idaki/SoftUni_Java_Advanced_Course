package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.utils.HelperUtils;

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
        Present present = presentRepository.findByName(presentName);
        List<Helper> helpers = helperRepository
                .getModels().stream()
                .filter(h -> h.getEnergy() > 50)
                .collect(Collectors.toList());

        if (helpers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }
        Shop shop = new ShopImpl();
        int brokenInstruments = 0;

        for (Helper helper : helpers) {
           if (present.isDone()){
               break;
           }

            shop.craft(present, helper);

            if (present.isDone()) {
                countDonePresents++;
            }
            brokenInstruments += helper.getInstruments().stream().filter(Instrument::isBroken).count();
        }


        String pattern = ConstantMessages.PRESENT_DONE
                + ConstantMessages.COUNT_BROKEN_INSTRUMENTS;


        return String.format(pattern
                , presentName
                , present.isDone()
                        ? "done"
                        : "not done"
                , brokenInstruments); //count to add
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
