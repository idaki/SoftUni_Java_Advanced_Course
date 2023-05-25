package LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PB06_Find_Evens_or_Odds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> print = new ArrayList<>();
        int[] borders = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int start = borders[0];
        int end = borders[1];
        String type = scanner.nextLine();
        BiFunction<Integer, Integer, List<Integer>> getList = (x, y) -> {
            List<Integer> list = new ArrayList<>();
            for (int i = x; i <= y; i++) {
                list.add(i);
            }
            return list;
        };

        if (type.contains("odd")) {
            print = getList.apply(start, end).stream().filter(e -> e % 2 != 0).collect(Collectors.toList());

        } else {
            print = getList.apply(start, end).stream().filter(e -> e % 2 == 0).collect(Collectors.toList());

        }
        print.forEach(e-> System.out.print(e+ " "));
    }
}
