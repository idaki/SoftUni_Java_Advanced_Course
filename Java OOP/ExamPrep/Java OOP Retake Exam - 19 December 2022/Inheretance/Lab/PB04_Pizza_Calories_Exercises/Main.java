package PB04_Pizza_Calories_Exercises;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaTokens = scanner.nextLine().split("\\s+");
        Pizza pizza = new Pizza(pizzaTokens[1], Integer.parseInt(pizzaTokens[2]));
        String[] doughTokens = scanner.nextLine().split("\\s+");
        Dough dough = new Dough(doughTokens[1],doughTokens[2],Double.parseDouble(doughTokens[3]));
        pizza.setDough(dough);
        //Dough Wholegrain Crispy 100

        String command= "";

        while (!"END".equals(command= scanner.nextLine())){
           String[] toppingTokens = command.split("\\s+");
            Topping topping =new Topping(toppingTokens[1],Integer.parseInt(toppingTokens[2]));
            pizza.addTopping(topping);
        }
        String pattern = "%s - %.2f";
        System.out.println(String.format(pattern, pizza.getName(),pizza.getOverallCalories()));


    }
}
