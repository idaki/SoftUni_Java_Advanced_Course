package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

import static vehicleShop.common.ConstantMessages.COUNT_BROKEN_INSTRUMENTS;
import static vehicleShop.common.ConstantMessages.VEHICLE_DONE;
import static vehicleShop.common.ExceptionMessages.NO_WORKER_READY;

public class ControllerImpl implements Controller {
    private WorkerRepository workerRepository;
    private VehicleRepository vehicleRepository;
    private int countMadeVehicle;

    public ControllerImpl() {
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.countMadeVehicle = 0;
    }

    @Override
    public String addWorker(String type, String workerName) {

        Worker worker;
        if ("FirstShift".equals(type)) {
            worker = new FirstShift(workerName);
        } else if ("SecondShift".equals(type)) {
            worker = new SecondShift(workerName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }
        workerRepository.getWorkers().add(worker);
        return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {

        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
        vehicleRepository.add(vehicle);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Tool tool = new ToolImpl(power);
        Worker worker = workerRepository.findByName(workerName);

        if (worker == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        worker.addTool(tool);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        List<Worker> workers = workerRepository.getWorkers().stream()
                .filter(w -> w.getStrength() > 70)
                .collect(Collectors.toList());

        if (workers.isEmpty()) {
            throw new IllegalArgumentException(NO_WORKER_READY);
        }

        Vehicle vehicle = vehicleRepository.findByName(vehicleName);

        Shop shop = new ShopImpl();
        long unshiftTools = 0;
        while (!workers.isEmpty() && !vehicle.reached()) {
            Worker worker = workers.get(0);
            shop.make(vehicle, worker);

            if (!worker.canWork() || worker.getTools().stream().noneMatch(t -> !t.isUnfit())) {
                unshiftTools += worker.getTools().stream().filter(Tool::isUnfit).count();
                workers.remove(worker);
                break;
            }
            unshiftTools += worker.getTools().stream().filter(Tool::isUnfit).count();
        }

        String infoAboutVehicle = "not done";
        if (vehicle.reached()) {
            infoAboutVehicle = "done";
            countMadeVehicle++;
        }
        StringBuilder output = new StringBuilder();
        output.append(String.format(VEHICLE_DONE, vehicleName, infoAboutVehicle));
        output.append(String.format(COUNT_BROKEN_INSTRUMENTS, unshiftTools));
        return output.toString().trim();
    }



    @Override
    public String statistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.countMadeVehicle).append(" vehicles are ready!").append(System.lineSeparator());
        sb.append("Info for workers:").append(System.lineSeparator());
        workerRepository.getWorkers().forEach(w -> {
            String name = w.getName();
            int strength = w.getStrength();
            int countTools = (int) w.getTools().stream().filter(t -> !t.isUnfit()).count();

            sb.append("Name: ").append(name).append(", Strength: ").append(strength).append(System.lineSeparator());
            sb.append("Tools: ").append(countTools).append(" fit left").append(System.lineSeparator());

        });

        return sb.toString().trim();
    }
}
