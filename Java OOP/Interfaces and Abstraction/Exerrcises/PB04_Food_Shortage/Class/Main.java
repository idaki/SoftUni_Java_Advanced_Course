package PB04_Food_Shortage.Class;

import PB04_Food_Shortage.Intterfaces.Buyer;

import java.util.*;

public class Main  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPeople = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyerMap= new HashMap<>();
        for (int i = 0; i <numPeople ; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens.length == 4){
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                String birthdate = tokens[3];
                buyerMap.putIfAbsent(name, new Citizen(name,age,id,birthdate));

            }else if (tokens.length == 3){
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String group = tokens[2];
                buyerMap.putIfAbsent(name, new Rebel(name,age,group));
            }

        }

        String name;

        while (!"End".equals( name = scanner.nextLine())){
        if (buyerMap.containsKey(name)){
            buyerMap.get(name).buyFood();
        }
        }

        int result = buyerMap.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(result);

    }
}
