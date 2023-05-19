package LAB;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PB04_Count_Real_Numbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[] arrayInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
      Map<Double, Integer> numMap = new LinkedHashMap<>();

        for (double element : arrayInput) {
            if (!numMap.containsKey(element)) {
                numMap.put(element, 1);
            } else {
                numMap.put(element, numMap.get(element) + 1);
            }
        }
        System.out.println();
        numMap.entrySet().forEach(e -> {
            System.out.printf("%.1f -> %d%n",e.getKey(),e.getValue());
        });


    }
}
