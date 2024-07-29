public class Card implements Comparable<Card> {
    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        String valueStr;
        switch (value) {
            case 11: valueStr = "J"; break;
            case 12: valueStr = "Q"; break;
            case 13: valueStr = "K"; break;
            case 14: valueStr = "A"; break;
            default: valueStr = Integer.toString(value);
        }
        return suit + " " + valueStr;
    }

    @Override
    public int compareTo(Card other) {
        if (this.value != other.value) {
            return Integer.compare(this.value, other.value);
        } else {
            return Integer.compare(this.suit.ordinal(), other.suit.ordinal());
        }
    }
}
