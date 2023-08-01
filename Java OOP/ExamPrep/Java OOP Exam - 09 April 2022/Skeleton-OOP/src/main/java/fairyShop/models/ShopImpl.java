package fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShopImpl implements Shop {


    @Override
    public void craft(Present present, Helper helper) {
        Collection<Instrument> instruments = helper.getInstruments();

        while (helper.canWork()
                && !present.isDone()
                && instruments.stream().filter(i->!i.isBroken()).iterator().hasNext()) {

            Instrument currentInstrument = instruments.iterator().next();
            helper.work();
            present.getCrafted();
            currentInstrument.use();


            if (currentInstrument.isBroken()) {

                    currentInstrument = instruments.iterator().next();
                }
            }

        }
}





