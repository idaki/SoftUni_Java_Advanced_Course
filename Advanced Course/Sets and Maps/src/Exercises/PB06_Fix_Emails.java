package Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class PB06_Fix_Emails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        LinkedHashMap<String, String> emailMap = new LinkedHashMap<>();

        while (!"stop".equals(input = scanner.nextLine())) {
            String name = input;
            String email = scanner.nextLine();





            if (email.contains(".us") || email.contains(".uk")|| email.contains(".com")) {
            } else {
                emailMap.put(name, email);
            }
        }
        emailMap.forEach((k,v)-> System.out.printf("%s -> %s%n",k,v));
    }
}
