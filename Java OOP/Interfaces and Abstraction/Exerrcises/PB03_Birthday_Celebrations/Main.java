package PB03_Birthday_Celebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> birthableObjects = new ArrayList<>();
        String line;

        while(!"End".equals(line= scanner.nextLine())){
            String[] tokens = line.split("\\s+");

            if (tokens[0].equals("Citizen")){
                String name= tokens[1];
                int age  = Integer.parseInt(tokens[2]);
                String id= tokens[3];
                String birthDate = tokens[4];
                birthableObjects.add(new Citizen(name, age, id, birthDate));

            } else if(tokens[0].equals("Pet")){
               String name= tokens[1];
               String birthDate = tokens[2];
                birthableObjects.add(new Pet(name,birthDate));
            }
        }
        String yearToCheck = scanner.nextLine();
        birthableObjects.stream().
                filter(i->i.getBirthDate().
                        endsWith(yearToCheck)).
                forEach(i-> System.out.println(i.getBirthDate()));


    }
}
