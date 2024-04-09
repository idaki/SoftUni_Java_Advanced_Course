package climbers.core;

import climbers.common.ConstantMessages;
import climbers.common.ExceptionMessages;
import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.Climbing;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;

import java.lang.management.MonitorInfo;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private ClimberRepository climberRepository;
    private MountainRepository mountainRepository;
    private int countMountainsClimbed;


    public ControllerImpl() {
        this.climberRepository = new ClimberRepository();
        this.mountainRepository = new MountainRepository();
        countMountainsClimbed =0;
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber = null;
        if (type.equals("WallClimber")) {
            climber = new WallClimber(climberName);
        } else if (type.equals("RockClimber")) {
            climber = new RockClimber(climberName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.CLIMBER_INVALID_TYPE);
        }

        this.climberRepository.add(climber);

        return String.format(ConstantMessages.CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {

        Mountain mountain = new MountainImpl(mountainName);
        mountain.getPeaksList().addAll(Arrays.asList(peaks));
        this.mountainRepository.add(mountain);
        return String.format(ConstantMessages.MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = this.climberRepository.byName(climberName);

        if (climber == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CLIMBER_DOES_NOT_EXIST, climberName));
        }
        this.climberRepository.remove(climber);


        return String.format(ConstantMessages.CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
       countMountainsClimbed++;
        Collection<Climber> climbers = this.climberRepository.getCollection().stream()
                .filter(Climber::canClimb)
                .collect(Collectors.toList());

        if(climbers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.THERE_ARE_NO_CLIMBERS);
        }

        Mountain mountain = this.mountainRepository.byName(mountainName);
        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain,climbers);
        int countClimbersRemoved= (int)climbers.stream().filter(climber -> !climber.canClimb()).count();
        return String.format(ConstantMessages.PEAK_CLIMBING,mountainName,countClimbersRemoved);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_MOUNTAIN_COUNT,countMountainsClimbed))
                .append(System.lineSeparator())
                .append(ConstantMessages.FINAL_CLIMBERS_STATISTICS)
                .append(System.lineSeparator());
        this.climberRepository.getCollection().stream().forEach(c->sb.append(c.toString()).append(System.lineSeparator()));



        return sb.toString().trim();
    }
}
