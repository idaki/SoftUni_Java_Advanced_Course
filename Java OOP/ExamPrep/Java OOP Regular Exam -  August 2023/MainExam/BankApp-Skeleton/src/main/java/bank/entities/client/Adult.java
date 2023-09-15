package bank.entities.client;

//Can only live in CentralBank!
public class Adult extends BaseClient {
    private static final int INITIAL_CLIENT_INTEREST = 4;
    private static final int CLIENT_INTEREST_INCREASE_FACTOR = 2;


    public Adult(String name, String ID, double income) {
        super(name, ID, INITIAL_CLIENT_INTEREST, income);
    }

    @Override
    public void increase() {
        super.setInterest(super.getInterest() + CLIENT_INTEREST_INCREASE_FACTOR);
    }
}
