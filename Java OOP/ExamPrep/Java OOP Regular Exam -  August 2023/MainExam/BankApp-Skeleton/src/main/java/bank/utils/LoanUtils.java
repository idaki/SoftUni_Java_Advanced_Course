package bank.utils;

import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;

public final class LoanUtils {
    private LoanUtils() {
    }

    public static boolean isLoanTypeValid(String type) {
        return "StudentLoan".equals(type) || "MortgageLoan".equals(type);
    }
    public static Loan createNewLoan(String type) {
        Loan loan = null;
        if ("StudentLoan".equals(type)) {
            loan = new StudentLoan();
        } else if ("MortgageLoan".equals(type)) {
            loan = new MortgageLoan();
        }
        return loan;
    }

}
