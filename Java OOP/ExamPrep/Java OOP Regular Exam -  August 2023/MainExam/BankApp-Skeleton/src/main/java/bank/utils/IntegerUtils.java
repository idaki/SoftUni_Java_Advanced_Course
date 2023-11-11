package bank.utils;

import bank.entities.client.Client;

import java.util.Collection;

public final class IntegerUtils {
    private IntegerUtils() {
    }
    public static boolean isCapacityAvailable(int capacity, Collection<Client> collection){
        return capacity > collection.size();
    }


}
