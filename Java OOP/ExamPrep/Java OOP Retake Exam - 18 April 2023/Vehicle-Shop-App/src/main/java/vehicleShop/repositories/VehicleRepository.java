package vehicleShop.repositories;

import vehicleShop.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collection;

public class VehicleRepository implements Repository<Vehicle> {
    Collection<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public Collection<Vehicle> getWorkers() {
        return this.vehicles;
    }

    @Override
    public void add(Vehicle model) {
        vehicles.add(model);

    }

    @Override
    public boolean remove(Vehicle model) {
        return vehicles.remove(model);
    }

    @Override
    public Vehicle findByName(String name) {
        return vehicles.stream().filter(v->v.getName().equals(name)).findFirst().orElse(null);
    }
}
