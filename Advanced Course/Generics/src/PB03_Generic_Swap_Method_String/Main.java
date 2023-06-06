package PB03_Generic_Swap_Method_String;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        GenericSwapMethod<Object> list= new GenericSwapMethod<>();
        for (int i = 0; i < n; i++) {
            list.getList().add(scanner.nextLine());
        }

        int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        list.setFirstIndex(tokens[0]);
        list.setSecondIndex(tokens[1]);
        list.swapMethod();
        list.getList().forEach(e-> System.out.println(e.getClass().getTypeName()+": "+e));



    }
}
