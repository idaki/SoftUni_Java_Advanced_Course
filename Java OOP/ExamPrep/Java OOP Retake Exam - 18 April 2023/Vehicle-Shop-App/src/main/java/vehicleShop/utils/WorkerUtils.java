package vehicleShop.utils;

import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;

public final class WorkerUtils {
    private WorkerUtils() {
    }

    public static boolean isValidWorkerType(String type) {
        return "FirstShift".equals(type) || "SecondShift".equals(type);
    }

    public static Worker createNewWorker(String type, String name) {
        Worker worker = null;
        if ("FirstShift".equals(type)) {
            worker = new FirstShift(name);
        } else if ("SecondShift".equals(type)) {
            worker = new SecondShift(name);
        }
        return worker;
    }
}
