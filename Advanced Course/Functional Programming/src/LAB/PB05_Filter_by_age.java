package LAB;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Predicate;

public class PB05_Filter_by_age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> userMap = readUserData(n, scanner);
        String condition = scanner.nextLine();
        int ageCheck = Integer.parseInt(scanner.nextLine());
        String printElements = scanner.nextLine();
        printResult(userMap, condition, ageCheck, printElements);


    }

    private static void printResult(LinkedHashMap<String, Integer> userMap, String condition, int ageCheck
            , String printElements) {

        if ("younger".contains(condition)) {
            for (Map.Entry<String, Integer> person : userMap.entrySet()) {
                if (person.getValue() < ageCheck) {
                    if ("name".equals(printElements)) {
                        System.out.println(person.getKey());
                    } else if ("age".equals(printElements)) {
                        System.out.println(person.getValue());
                    } else {
                        System.out.println(person.getKey() + " - " + person.getValue());
                    }
                }
            }
        } else {
            for (Map.Entry<String, Integer> person : userMap.entrySet()) {
                if (person.getValue() >= ageCheck) {
                    if ("name".equals(printElements)) {
                        System.out.println(person.getKey());
                    } else if ("age".equals(printElements)) {
                        System.out.println(person.getValue());
                    } else {
                        System.out.println(person.getKey() + " - " + person.getValue());
                    }
                }
            }
        }
    }


    private static LinkedHashMap readUserData(int n, Scanner scanner) {
        LinkedHashMap<String, Integer> userMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] inputArr = scanner.nextLine().split(",\\s+");
            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);
            if (!userMap.containsKey(name)) {
                userMap.put(name, age);
            }
        }
        return userMap;
    }
}
