package bank.entities.loan;

public class StudentLoan extends BaseLoan {
    private static final int INTEREST_RATE = 1;
    private static final double LOAN_AMOUNT = 10000;

    public StudentLoan() {
        super(INTEREST_RATE,LOAN_AMOUNT);
    }
}
