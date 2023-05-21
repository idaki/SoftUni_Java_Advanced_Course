package Exercises;

import java.util.HashMap;
import java.util.Scanner;

public class PB05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phoneBookMap = new HashMap<>();
        String input = "";
        while (!"search".equals(input = scanner.nextLine())) {
            String[] inputArr = input.split("-");
            String name = inputArr[0];
            if (inputArr.length < 2) {
                continue;
            }
                String phone = inputArr[1];

            if (!phoneBookMap.containsKey(name)) {
                phoneBookMap.put(name, phone);
            }
        }


        while (!"stop".equals(input = scanner.nextLine())) {
            if (phoneBookMap.containsKey(input)){
                System.out.println(input+" -> "+phoneBookMap.get(input));
            }else{
                System.out.printf("Contact %s does not exist.%n",input);
            }
        }

    }
}
