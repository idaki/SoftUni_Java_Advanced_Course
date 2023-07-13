package PB05_Border_Control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;

        List<Identifiable> identifiableObjects = new ArrayList<>();

        while (!"End".equalsIgnoreCase(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");

            if (data.length == 3) {
                // citizen
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                Identifiable citizen = new Citizen(name,age,id);
                identifiableObjects.add(citizen);
            } else if (data.length == 2) {
                // robots
                String model = data[0];
                String id = data[1];
                Identifiable robot = new Robot(id,model);
                identifiableObjects.add(robot);
            }
        }

        String fakeIdSuffix = scanner.nextLine();

        identifiableObjects.stream()
                .filter(i -> i.getId().endsWith(fakeIdSuffix))
                .forEach(i -> System.out.println(i.getId()));

    }
      /*  Scanner scanner = new Scanner(System.in);
        String line = "";
        List<Identifiable> identifiableObjects = new ArrayList<>();
        while (!"End".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            if (tokens.length == 3) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                identifiableObjects.add(new Citizen(name, age, id));
            } else if (tokens.length == 2) {
                String model = tokens[0];
                String id = tokens[1];
                identifiableObjects.add(new Robot(id, model));
            }
        }
        String fakeID = scanner.nextLine();
        identifiableObjects.stream()
                .filter(i->i.getId().endsWith(fakeID))
                .forEach(i-> System.out.println(i.getId()));
    }*/
}
