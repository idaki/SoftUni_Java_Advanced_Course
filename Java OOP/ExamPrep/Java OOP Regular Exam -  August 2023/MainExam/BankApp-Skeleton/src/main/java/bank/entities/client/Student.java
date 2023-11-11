package bank.entities.client;
// Can only live in BranchBank! BranchBank
public class Student extends BaseClient{
    private static final int INITIAL_CLIENT_INTEREST = 2;
    private static final int CLIENT_INTEREST_INCREASE_FACTOR = 1;


    public Student(String name, String ID, double income) {
        super(name, ID, INITIAL_CLIENT_INTEREST, income);
    }

    @Override
    public void increase() {
        super.setInterest(super.getInterest()+CLIENT_INTEREST_INCREASE_FACTOR);
    }
}
