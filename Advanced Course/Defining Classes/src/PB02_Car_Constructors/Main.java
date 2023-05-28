package PB02_Car_Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n ; i++) {

            String[] carInfo = scanner.nextLine().split("\\s+");
            if ( carInfo.length==1){
                String brand = carInfo[0];
                Car car = new Car(brand);
                System.out.println(car);
            }else if (carInfo.length==3){
                String brand = carInfo[0];
                String model = carInfo[1];
                int hp = Integer.parseInt(carInfo[2]);
                Car car = new Car(brand,model, hp);
                System.out.println(car);
            }



        }

    }
}
