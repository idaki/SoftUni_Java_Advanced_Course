package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.Collection;

public class ShopImpl implements Shop {
    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Collection<Tool> tools = worker.getTools();

        while (worker.canWork()
                && !vehicle.reached()
                && tools.stream()
                .filter(t -> !t.isUnfit())
                .iterator().hasNext()){

            Tool tool = tools.stream()
                    .filter(t -> !t.isUnfit())
                    .iterator().next();

            worker.working();
            vehicle.making();
            tool.decreasesPower();
        }



}
}
