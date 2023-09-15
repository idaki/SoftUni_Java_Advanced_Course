package bank.utils;

import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;

public final class ClientUtils {
    private ClientUtils() {
    }

    public static boolean isClientTypeValid(String type) {
        return "Student".equals(type) || "Adult".equals(type);
    }

    public static boolean isClientTypeSuitableForTheBankType(String clientType, String bankType) {
        return ("Student".equals(clientType) && "BranchBank".equals(bankType))
                || ("Adult".equals(clientType)&& "CentralBank".equals(bankType));
    }

    public static Client createNewClient(String clientType, String bankType, String name, String ID, double income){

        Client client = null;

        if ("Student".equals(clientType) && "BranchBank".equals(bankType)){
            client = new Student(name, ID, income);
        } else if(("Adult".equals(clientType)&& "CentralBank".equals(bankType))){
            client = new Adult(name, ID, income);
        }

return client;
    }

}
