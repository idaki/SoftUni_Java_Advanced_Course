package PB03_Cards_with_Power;

public enum Suite {
    CLUBS  (0), DIAMONDS  (13), HEARTS (26), SPADES (39);
    private int power;
    Suite(int power){
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}

