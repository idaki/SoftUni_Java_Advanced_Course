package Exercises;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class PB01_Unique_Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> set  = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n ; i++) {
            String input = scanner.nextLine();
            if (!set.contains(input)){
                set.add(input);
            }
        }

        set.forEach(e-> System.out.println(e));
    }
}
