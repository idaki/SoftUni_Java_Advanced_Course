package PB01_Card_Suit_E;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (CardsSuit cardSuit: CardsSuit.values()) {
            System.out.println("Ordinal value: "+cardSuit.ordinal()+";  Name value: "+cardSuit.name());
        }
    }
}
