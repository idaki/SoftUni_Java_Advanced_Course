import java.util.*;

public class PB01_KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] platesInput = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] carsInput = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        ArrayDeque<Integer> platesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carsStack = new ArrayDeque<>();
        Arrays.stream(platesInput).forEach(platesQueue::offer);
        Arrays.stream(carsInput).forEach(carsStack::push);

        List<Integer> carsList = new ArrayList<>();


        while (!platesQueue.isEmpty() && !carsStack.isEmpty()) {
            int cars = carsStack.pop();
            int plates = platesQueue.poll();
            int countCars = 0;
            int sets = 0;

            if (plates != 0) {
                sets = plates / 2;
            }

            if (sets == cars) {
                countCars = cars;
                cars = 0;
                plates = 0;
            } else if (sets > cars) {
                countCars = cars;
                cars = 0;
                plates -= countCars*2;

            } else if (sets < cars) {
                countCars = sets;
                cars-=sets;
                plates = 0;
            }


            if (cars > 0) {
                carsStack.offer(cars);
            }

            if (plates > 0) {
                platesQueue.offer(plates);
            }

            carsList.add(countCars);
        }
        int sumCars = carsList.stream().mapToInt(Integer::valueOf).sum();
        System.out.printf("%d cars were registered for %d days!%n", sumCars, carsList.size());

        if (carsStack.isEmpty() & platesQueue.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
        if (!platesQueue.isEmpty()) {
            int sum = 0;
            while (!platesQueue.isEmpty()) {
                sum += platesQueue.poll();
            }
            System.out.println(sum + " license plates remain!");
        }

        if (!carsStack.isEmpty()) {
            int sum = 0;
            while (!carsStack.isEmpty()) {
                sum += carsStack.pop();
            }
            System.out.println(sum + " cars remain without license plates!");
        }


    }


}