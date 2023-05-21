package Exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class PB02_Sets_of_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arrayInput[0];
        int m = arrayInput[1];

        LinkedHashSet<Integer> nSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> mSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            int nElement = Integer.parseInt(scanner.nextLine());
            if (!nSet.contains(nElement)) {
                nSet.add(nElement);
            }
        }

        for (int i = 0; i < m; i++) {
            int mElement = Integer.parseInt(scanner.nextLine());
            if (!mSet.contains(mElement)) {
                mSet.add(mElement);
            }
        }


        nSet.retainAll(mSet);
        nSet.forEach(e -> System.out.print(e + " "));

    }
}
