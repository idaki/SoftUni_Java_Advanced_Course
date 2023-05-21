package Exercises;

import java.util.Scanner;
import java.util.TreeSet;

public class PB03_Periodic_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> resultSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < input.length ; j++) {
                if (!resultSet.contains(input[j])){
                    resultSet.add(input[j]);
                }
            }
        }
        resultSet.forEach(e-> System.out.print(e+" "));
    }
}
