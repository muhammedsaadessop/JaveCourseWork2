

public class Main {

    public static void main(String[] args) {
        Hand hand = new Hand();
        hand.add(new Card(12, Suit.HEART));
        hand.add(new Card(4, Suit.SPADE));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(14, Suit.SPADE));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));

        System.out.println("Original Hand:");
        hand.print();

        System.out.println("\nSorted Hand:");
        hand.sort();
        hand.print();

        System.out.println("\nSorted by Suit:");
        hand.sortBySuit();
        hand.print();
    }
}
