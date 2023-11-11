package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;
import glacialExpedition.utils.ExplorerUtils;

import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Explorer> explorersRepository;
    private Repository<State> statesRepository;
    private int countExploredStates;

    public ControllerImpl() {
        this.explorersRepository = new ExplorerRepository();
        this.statesRepository = new StateRepository();
        this.countExploredStates = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        if (!ExplorerUtils.isExplorerTypeValid(type)) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }



        Explorer explorer = ExplorerUtils.createNewExplorer(type, explorerName);

        explorersRepository.add(explorer);

        return String.format(ConstantMessages.EXPLORER_ADDED
                , type
                , explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }

        statesRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED
                , stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorersRepository.byName(explorerName);

       if (!explorersRepository.remove(explorer)) {
           throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST
                   , explorerName));
       }

           return String.format(ConstantMessages.EXPLORER_RETIRED
                   , explorerName);
       }


    @Override
    public String exploreState(String stateName) {
        Collection<Explorer> explorers = explorersRepository.getCollection().stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());
        int initialExplorerCount = explorers.size();

        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        State state = statesRepository.byName(stateName);
        Mission mission = new MissionImpl();
        mission.explore(state, explorers);
        String pattern = ConstantMessages.STATE_EXPLORER;
        int countRetiredExplorers = explorers.stream().filter(e->!e.canSearch()).collect(Collectors.toList()).size();

        countExploredStates++;
        return String.format(pattern,
                stateName, countRetiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED
                        , this.countExploredStates))
                .append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_EXPLORER_INFO)
                .append(System.lineSeparator());


        for (Explorer explorer : explorersRepository.getCollection()) {
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME
                            , explorer.getName()))
                    .append(System.lineSeparator());

            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY
                            , explorer.getEnergy()))
                    .append(System.lineSeparator());

            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS
                    , explorer.getSuitcase().getExhibits().isEmpty() ?
                            "None"
                            : String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER
                                    , explorer.getSuitcase().getExhibits())))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
