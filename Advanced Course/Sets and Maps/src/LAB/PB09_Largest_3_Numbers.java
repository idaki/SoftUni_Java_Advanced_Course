package LAB;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PB09_Largest_3_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sortedList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toList());
        Collections.reverse(sortedList);
        if (sortedList.size() > 3) {
            for (int i = 0; i <3; i++) {
                System.out.print(sortedList.get(i) + " ");
            }
        } else{

            System.out.println(sortedList.toString().replaceAll("[\\[\\],]",""));
        }


    }
}
