package LAB;

import java.util.*;
import java.util.stream.Collectors;

public class PB01_Sort_Even_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(list.stream().filter(e -> e % 2 == 0).map(Object::toString)
                .collect(Collectors.joining(", ")));
        System.out.println(list.stream().filter(e -> e % 2 == 0).sorted().map(Object::toString)
                .collect(Collectors.joining(", ")));



    }
}
