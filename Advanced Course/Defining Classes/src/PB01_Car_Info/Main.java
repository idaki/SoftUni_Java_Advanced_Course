package PB01_Car_Info;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car= new Car();


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n ; i++) {

            String carInfo = scanner.nextLine();
            String brand = carInfo.split("\\s+")[0];
            String model = carInfo.split("\\s+")[1];
            int hp = Integer.parseInt(carInfo.split("\\s+")[2]);

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsepower(hp);

            System.out.println(car.toString());
        }
    }
}
