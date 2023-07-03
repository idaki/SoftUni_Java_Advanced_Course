package PB03_Random_Array_List;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("A","B","C","D","E"));
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.getRandomElement(test);

    }
}
