package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.Collection;

public class ShopImpl implements Shop {
    @Override //TODO Check logic- possible issues with logic impl


    public void make(Vehicle vehicle, Worker worker) {
        Collection<Tool> tools = worker.getTools();
        while (worker.canWork() && !vehicle.reached() && tools.iterator().hasNext()) {
            Tool currentTool = tools.iterator().next();
            currentTool.decreasesPower();
            worker.working();
            vehicle.making();
            if (currentTool.isUnfit()) {

                currentTool = tools.iterator().next();

            }
        }

    }


  /*  public void make(Vehicle vehicle, Worker worker) {
        Tool currentTool = worker.getTools().iterator().next();
        worker.getTools().remove(currentTool);
        while (worker.canWork() && !currentTool.isUnfit()) {
            while (!vehicle.reached()
                    && worker.canWork()
                    && !currentTool.isUnfit()
                    && !worker.getTools().isEmpty()) {
                worker.working();
                if (currentTool.isUnfit() && (!worker.getTools().isEmpty())) {
                    currentTool = worker.getTools().iterator().next();
                    worker.getTools().remove(currentTool);
                }
            }
        }
    }*/
}
