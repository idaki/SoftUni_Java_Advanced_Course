package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.museum.Museum;
import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class OperationImpl implements Operation {


    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {

        List<String> exhibits = new ArrayList<>(spot.getExhibits());

        for (Discoverer discoverer: discoverers) {
            while (discoverer.canDig() && exhibits.stream().iterator().hasNext()) {
                discoverer.dig();
                String currentExhibit = exhibits.stream().iterator().next();
                discoverer.getMuseum().getExhibits().add(currentExhibit);
                exhibits.remove(currentExhibit);
            }
        }

    }
}

