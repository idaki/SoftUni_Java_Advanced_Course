package bank.entities.loan;

public class MortgageLoan extends BaseLoan {
    private static final int INTEREST_RATE = 3;
    private static final double LOAN_AMOUNT = 50000;
//todo check logic // could be private or protected
    public MortgageLoan() {
        super(INTEREST_RATE, LOAN_AMOUNT);
    }
}
