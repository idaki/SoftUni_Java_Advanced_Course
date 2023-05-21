package Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class PB04_Count_Symbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      TreeMap<Character, Integer> resultMap = new TreeMap<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.toCharArray().length ; i++) {
          char[] current = input.toCharArray();
          if (!resultMap.containsKey(current[i])){
              resultMap.put(current[i],1);
          }else {
              int count = resultMap.get(current[i]);
              resultMap.replace(current[i],count+1);
          }
        }
        resultMap.entrySet().forEach(e-> System.out.printf("%s: %d time/s%n",e.getKey(),e.getValue()));
    }
}
