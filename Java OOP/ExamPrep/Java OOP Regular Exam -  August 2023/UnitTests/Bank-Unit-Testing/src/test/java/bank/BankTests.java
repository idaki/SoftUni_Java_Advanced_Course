package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTests {
    private static final int BANK_CAPACITY = 10;
    private static final String BANK_NAME = "ING";
    private static final String CLIENT1_NAME = "Dirk";
    private static final String CLIENT2_NAME = "Bas";

    private Bank bank;
    private Client client1;
    private Client client2;

    @Before
    public void setup(){
        this.bank = new Bank(BANK_NAME,BANK_CAPACITY);
        this.client1 = new Client(CLIENT1_NAME);
        this.client2 = new Client(CLIENT1_NAME);
        bank.addClient(client1);
        bank.addClient(client2);
    }

    @Test
    public void testGetNamePositiveCase(){
        Assert.assertEquals(BANK_NAME, bank.getName());
    }

    @Test
    public void testSetNamePositiveCase(){
        Assert.assertEquals(BANK_NAME, bank.getName());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNegativeCaseWhenNameIsNull(){
        Bank bank = new Bank(null,BANK_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNegativeCaseWhenNameEmptySpaces(){
        Bank bank = new Bank("   ",BANK_CAPACITY);
    }

    @Test
    public void testGetCapacityPositiveCase(){
        Assert.assertEquals(BANK_CAPACITY, bank.getCapacity());
    }

    @Test
    public void testSetCapacityPositiveCase(){
        Assert.assertEquals(BANK_CAPACITY, bank.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetCapacityNegativeCaseWhenCapacityIsNegativeNumber(){
        Bank bank = new Bank(BANK_NAME,-1);
    }

    @Test
    public void testGetCountPositiveCase(){

        bank.addClient(client1);
        Assert.assertEquals(1, bank.getCount());
    }
//todo check logic
    @Test
    public void testAddClientPositiveCase(){

        Assert.assertEquals(2, bank.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddClientNegativeCaseWhenOutOfCapacity(){
        bank.addClient(client1);
        bank.addClient(client2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLoanWithdrawalNegativeCaseWhenClientSearchReturnsNull(){
        Client clientExpected = bank.loanWithdrawal(CLIENT2_NAME);
    }
    @Test
    public void testLoanWithdrawalWhenClientIsSetForApprovalAndReturnsFalse  (){

        Client clientExpected = bank.loanWithdrawal(CLIENT1_NAME);
        Assert.assertFalse(clientExpected.isApprovedForLoan());
    }

    @Test
    public void testGetStatisticsPositiveCaseWithMultipleClients(){
        bank.addClient(client1);
        bank.addClient(client2);
        String clients = "Dirk, Bas";
        String expected = String.format("The client %s is at the %s bank!", clients, BANK_NAME);

        Assert.assertEquals(expected, bank.statistics());
    }
    @Test
    public void testGetStatisticsPositiveCaseWithSingleClient(){
        bank.addClient(client1);
        String expected = String.format("The client %s is at the %s bank!", CLIENT1_NAME, BANK_NAME);

        Assert.assertEquals(expected, bank.statistics());
    }

    @Test
    public void testRemoveClientPositiveCase() {
        bank.addClient(client1);
        bank.addClient(client2);

        bank.removeClient(CLIENT1_NAME);

        Assert.assertEquals(1, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveClientNegativeCaseWhenClientNotFound() {
        Bank bank = new Bank(BANK_NAME, BANK_CAPACITY);
        bank.removeClient(CLIENT1_NAME);
    }



}
