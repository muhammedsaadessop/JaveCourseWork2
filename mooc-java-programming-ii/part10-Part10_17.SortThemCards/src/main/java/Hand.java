import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards = new ArrayList<>();

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(cards);
    }

    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand other) {
        int thisSum = cards.stream().mapToInt(Card::getValue).sum();
        int otherSum = other.cards.stream().mapToInt(Card::getValue).sum();
        return Integer.compare(thisSum, otherSum);
    }
}
