package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        List<String> availableExhibits = new ArrayList<>(state.getExhibits());
        List<Explorer> explorerList = new ArrayList<>(explorers);



        for (Explorer explorer : explorerList) {
            while (explorer.canSearch() && !availableExhibits.isEmpty()) {
                explorer.search();
                String currentExhibit = availableExhibits.get(0);
                explorer.getSuitcase().getExhibits().add(currentExhibit);
                availableExhibits.remove(0);
            }
        }
    }
}
