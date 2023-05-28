package PB03_Bank_Account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!"End".equals(input = scanner.nextLine())){
            if ( input.contains("Create")){
                BankAccount bankAccount = new BankAccount();
                System.out.println(bankAccount.getId());
            } else if ( input.contains("Deposit")) {
                int accountID = Integer.parseInt(input.split("\\s+")[1]);
                int depositAmount = Integer.parseInt(input.split("\\s+")[2]);

            }
        }
        System.out.println();
        //Create
        //Deposit 1 20
        //GetInterest 1 10
        //End
    }
}
