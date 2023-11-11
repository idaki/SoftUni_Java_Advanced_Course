package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import vehicleShop.utils.WorkerUtils;

import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Vehicle> vehicleRepository;
    private Repository<Worker> workerRepository;
    private int countVehicleMade;

    public ControllerImpl() {
        this.vehicleRepository = new VehicleRepository();
        this.workerRepository = new WorkerRepository();
        countVehicleMade = 0;
    }

    @Override
    public String addWorker(String type, String workerName) {

        if (!WorkerUtils.isValidWorkerType(type)) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }

        Worker worker = WorkerUtils.createNewWorker(type, workerName);

        workerRepository.add(worker);

        return String.format(ConstantMessages.ADDED_WORKER,type,workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {

        vehicleRepository.add(new VehicleImpl(vehicleName, strengthRequired));

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = workerRepository.findByName(workerName);
        if (worker == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        worker.getTools().add(new ToolImpl(power));

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        Collection<Worker> workers = workerRepository
                .getWorkers()
                .stream()
                .filter(w -> w.getStrength() > 70 )
                .collect(Collectors.toList());

        if (workers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }

        Vehicle vehicle = vehicleRepository.findByName(vehicleName);

        Shop shop = new ShopImpl();
        int countBrokenTools = 0;
        for (Worker worker : workers) {
           if (vehicle.reached()){
               break;
           }
            shop.make(vehicle, worker);

            if ( vehicle.reached()){
                countVehicleMade++;
            }
            countBrokenTools+= worker.getTools().stream().filter(t->t.isUnfit()).count();
        }



        String partOne = String.format(ConstantMessages.VEHICLE_DONE, vehicleName, vehicle.reached() ? "done" : "not done");
        String partTwo = String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, countBrokenTools);

        return partOne + partTwo;
    }

    @Override
    public String statistics() {
        StringBuilder sb = new StringBuilder();
        String pattern = ConstantMessages.COUNT_VEHICLE_READY +
                System.lineSeparator()
                + ConstantMessages.INFO_WORKERS
                + System.lineSeparator();

        sb.append(String.format(ConstantMessages.COUNT_VEHICLE_READY,countVehicleMade))
                .append(System.lineSeparator());
        sb.append(ConstantMessages.INFO_WORKERS)
                .append(System.lineSeparator());

        workerRepository.getWorkers().forEach(w -> sb.append(w.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
