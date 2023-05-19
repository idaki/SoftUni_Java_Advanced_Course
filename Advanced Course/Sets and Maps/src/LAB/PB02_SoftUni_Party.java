package LAB;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class PB02_SoftUni_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> guestList = new TreeSet<>();

        String input= "";
         while (!"END".equals(input=scanner.nextLine())){

             if(guestList.contains(input)){
                 guestList.remove(input);
             }else if (input.length()== 8){
                 guestList.add(input);
             }
         }
        System.out.println(guestList.size());
         guestList.forEach(e-> System.out.println(e));
    }
}
