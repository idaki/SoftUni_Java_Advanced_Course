package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class BaseService implements Service {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;


    public BaseService(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        if (name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public Collection<Robot> getRobots() {
        return robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public String getStatistics() {


     return String.format("%s %s:%n", this.name, this.getClass().getSimpleName())
                + String.format("Robots: %s%n", getRobots().isEmpty()
                ? "none"
                : this.getRobots().stream().map(Robot::getName).collect(Collectors.joining(" ")).trim())
                + String.format("Supplements: %s Hardness: %s%n", this.getSupplements().size(), this.sumHardness());

    }

    @Override
    public void addRobot(Robot robot) {
        if (robots.size() >= capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        robots.add(robot);

    }
//todo  To Verify if needed to add availability Check
    @Override
    public void removeRobot(Robot robot) {
        robots.remove(robot);

    }

    @Override
    public void addSupplement(Supplement supplement) {
       supplements.add(supplement);

    }

    @Override
    public void feeding() {
     robots.forEach(Robot::eating);
    }

    //todo TO VERIFY this stream works correctly
    @Override
    public int sumHardness() {
        return this.supplements.stream()
                .mapToInt(Supplement::getHardness)
                .sum();
    }


}
