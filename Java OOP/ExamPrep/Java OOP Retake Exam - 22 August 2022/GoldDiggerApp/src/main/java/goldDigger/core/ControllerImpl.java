package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private int finalSpotsInspected;


    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        finalSpotsInspected = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discover;
        if ("Archaeologist".equals(kind)) {
            discover = new Archaeologist(discovererName);
        } else if ("Anthropologist".equals(kind)) {
            discover = new Anthropologist(discovererName);
        } else if ("Geologist".equals(kind)) {
            discover = new Geologist(discovererName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discover);

        return String.format(ConstantMessages.DISCOVERER_ADDED
                , kind
                , discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        List<String> exhibitsList = Arrays.stream(exhibits)
                .collect(Collectors.toList());
        exhibitsList.forEach(e -> spot.getExhibits().add(e));
        spotRepository.add(spot);


        return String.format(ConstantMessages.SPOT_ADDED
                , spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository.byName(discovererName);

        if (!discovererRepository.remove(discoverer)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST
                    , discovererName));
        }

        discovererRepository.remove(discoverer);

        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        finalSpotsInspected++;
        Spot spot = spotRepository.byName(spotName);
        //todo check the count
        long excludedDiscoverersCount = discovererRepository.getCollection().stream().filter(d->d.getEnergy()<=45).count();

        Collection<Discoverer> discoverers = discovererRepository.getCollection().stream()
                .filter(d -> d.getEnergy() > 45)
                .collect(Collectors.toList());

        if (discoverers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Operation operation = new OperationImpl();
        operation.startOperation(spot, discoverers);



        return String.format(ConstantMessages.INSPECT_SPOT
                , spotName
                , excludedDiscoverersCount);

    }

    @Override
    public String getStatistics() {
        Collection<Discoverer> discoverers = discovererRepository.getCollection();


        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT, finalSpotsInspected))
                .append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_DISCOVERER_INFO)
                .append(System.lineSeparator());

        for (Discoverer discover : discoverers) {
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME, discover.getName()))
                    .append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, discover.getEnergy()))
                    .append(System.lineSeparator());

            if (discover.getMuseum().getExhibits().isEmpty()) {
                sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None"))
                        .append(System.lineSeparator());
            } else {
                List<String> exhibits = new ArrayList<>(discover.getMuseum().getExhibits());
                String museumsPrint = String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER
                        , exhibits);
                sb.append(String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, museumsPrint));
            }
        }

        return sb.toString().trim();

    }
}
