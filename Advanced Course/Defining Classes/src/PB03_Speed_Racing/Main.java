package PB03_Speed_Racing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double fuelConsumption = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuel, fuelConsumption);
            cars.put(model, car);
        }
        String line = "";
        while (!"End".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            String model = tokens[1];

            double distance = Double.parseDouble(tokens[2]);
           Car carToDrive = cars.get(model);

           if (!carToDrive.drive(distance)){
               System.out.println("Insufficient fuel for the drive");
           }
        }
        for (Car car: cars.values()) {
            System.out.println(car);
        }
    }


}
