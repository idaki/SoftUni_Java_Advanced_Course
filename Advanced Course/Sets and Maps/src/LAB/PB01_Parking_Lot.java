package LAB;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class PB01_Parking_Lot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet< String> carSet = new LinkedHashSet<>();
        String input ="";

        while(!"END".equals(input=scanner.nextLine())){

            String[] command = input.split(", ");
            String car = command[1];

            if ( input.contains("IN")) {
                carSet.add(car);
            } else  {
                carSet.remove(car);
            }

        }
       if (!carSet.isEmpty()) {
           carSet.forEach(e -> System.out.println(e));
       }else{
           System.out.println("Parking Lot is Empty");
       }
       }
}
