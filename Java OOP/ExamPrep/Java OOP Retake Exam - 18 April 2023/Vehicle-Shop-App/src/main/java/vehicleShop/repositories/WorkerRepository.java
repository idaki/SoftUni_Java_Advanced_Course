package vehicleShop.repositories;

import vehicleShop.models.worker.Worker;

import java.util.ArrayList;
import java.util.Collection;

public class WorkerRepository implements Repository<Worker> {
    Collection<Worker> workers;

    public WorkerRepository() {
        this.workers = new ArrayList<>();
    }

    @Override
    public Collection<Worker> getWorkers() {
        return this.workers;
    }

    @Override
    public void add(Worker model) {
        workers.add(model);
    }

    @Override
    public boolean remove(Worker model) {
        return workers.remove(model);
    }

    @Override
    public Worker findByName(String name) {
        return workers.stream().filter(w->w.getName().equals(name)).findFirst().orElse(null);
    }
}
