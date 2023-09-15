package bank.utils;

import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;

public final class BankUtils {
    private BankUtils() {
    }

    public static boolean isBankTypeValid(String type) {
        return "CentralBank".equals(type) || "BranchBank".equals(type);
    }

    public static Bank createNewBank(String type, String name) {
        Bank bank = null;
        if ("CentralBank".equals(type)) {
            bank = new CentralBank(name);
        } else if ("BranchBank".equals(type)) {
            bank = new BranchBank(name);
        }
        return bank;
    }
}
