package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.INVALID_ROBOT_TYPE;
import static robotService.common.ExceptionMessages.NO_SUPPLEMENT_FOUND;

public class ControllerImpl implements Controller {

    private SupplementRepository supplementRepository;
    private Map<String, Service> services;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepository();
        this.services = new LinkedHashMap<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        if ("MainService".equals(type)) {
            service = new MainService(name);
        } else if ("SecondaryService".equals(type)) {
            service = new SecondaryService(name);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }

        services.put(name, service);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        if ("PlasticArmor".equals(type)) {
            supplement = new PlasticArmor();
        } else if ("MetalArmor".equals(type)) {
            supplement = new MetalArmor();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        this.supplementRepository.addSupplement(supplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplementForService = this.supplementRepository.findFirst(supplementType);

        if (supplementForService == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Service service = this.services.get(serviceName);
        service.addSupplement(supplementForService);
        this.supplementRepository.removeSupplement(supplementForService);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);

    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        if ("MaleRobot".equals(robotType)) {
            robot = new MaleRobot(robotName, robotKind, price);
        } else if ("FemaleRobot".equals(robotType)) {
            robot = new FemaleRobot(robotName, robotKind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }

        Service service = this.services.get(serviceName);

        String output;

        if (!isSuitableService(robotType, service)) {
            output = UNSUITABLE_SERVICE;
        } else {
            service.addRobot(robot);
            output = String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
        }

        return output;

    }

    private boolean isSuitableService(String robotType, Service service) {
        String serviceType = service.getClass().getSimpleName();

        if (robotType.equals("FemaleRobot") && serviceType.equals("SecondaryService")) {
            return true;
        } else if (robotType.equals("MaleRobot") && serviceType.equals("MainService")) {
            return true;
        }

        return false;
    }



    @Override
    public String feedingRobot(String serviceName) {
    services.get(serviceName).getRobots().forEach(Robot::eating);
    int robotCount=   services.get(serviceName).getRobots().size();
        return String.format("Robots fed: %d",robotCount);
    }

    @Override
    public String sumOfAll(String serviceName) {

        double robotTotalPriceSum = services.get(serviceName)
                .getRobots()
                .stream()
                .mapToDouble(Robot::getPrice)
                .sum();
        double supplementsTotalPriceSum = services.get(serviceName)
                .getSupplements()
                .stream()
                .mapToDouble(Supplement::getPrice)
                .sum();

        double totalPriceSum =robotTotalPriceSum + supplementsTotalPriceSum;
        String pattern = "The value of service %s is %.2f.";

        return String.format(pattern,serviceName,totalPriceSum) ;
    }

    @Override
    public String getStatistics() {
        return services.values().stream()
                .map(Service::getStatistics)
                .collect(Collectors.joining(System.lineSeparator())).trim();
    }
}
