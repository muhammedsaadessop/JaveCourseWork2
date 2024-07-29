import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getSuit() != c2.getSuit()) {
            return Integer.compare(c1.getSuit().ordinal(), c2.getSuit().ordinal());
        } else {
            return Integer.compare(c1.getValue(), c2.getValue());
        }
    }
}
