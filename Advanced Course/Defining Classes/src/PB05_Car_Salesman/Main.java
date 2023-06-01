package PB05_Car_Salesman;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, List<Engine>> engines = new HashMap<>();
         List<Car> cars = new LinkedList<>();
        Predicate<String> isNumeric = str -> str.matches("-?\\d+");
        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            engines.putIfAbsent(model, new ArrayList<>());
            if (tokens.length == 2) {
                engines.get(model).add(new Engine(model, power));
            }
            if (tokens.length == 3 && isNumeric.test(tokens[2])) {
                int displacement = Integer.parseInt(tokens[2]);
                engines.get(model).add(new Engine(model, power, displacement));
            } else if (tokens.length == 3 && !isNumeric.test(tokens[2])) {
                String efficiency = tokens[2];
                engines.get(model).add(new Engine(model, power, efficiency));
            } else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engines.get(model).add(new Engine(model, power, displacement, efficiency));
            }
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String carModel = tokens[0];
            String engineModel = tokens[1];
            Engine currentEngine = engines.get(engineModel).get(0);

            if (tokens.length == 2) {
                Car car = new Car(carModel, currentEngine);
                cars.add(car);
            } else if (tokens.length == 3 && isNumeric.test(tokens[2])) {
                int weight = Integer.parseInt(tokens[2]);
                Car car = new Car(carModel, currentEngine, weight);
                cars.add(car);
            } else if (tokens.length == 3 && !isNumeric.test(tokens[2])) {
                String color = tokens[2];
                Car car = new Car(carModel, currentEngine,color);
                cars.add(car);
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                Car car = new Car(carModel, currentEngine,weight,color);
                cars.add(car);
            }

        }
      cars.forEach(System.out::print);
    }
}
