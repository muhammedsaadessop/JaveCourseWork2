import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {
    private ArrayList<Integer> numbers;
    private static final int NUMBERS_COUNT = 7;
    private static final int MAX_NUMBER = 40;
    private Random random;

    public LotteryRow() {
        this.random = new Random();
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }

    public void randomizeNumbers() {
        this.numbers = new ArrayList<>();
        while (this.numbers.size() < NUMBERS_COUNT) {
            int num = random.nextInt(MAX_NUMBER) + 1; 
            if (!this.containsNumber(num)) {
                this.numbers.add(num);
            }
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LotteryRow otherRow = (LotteryRow) other;
        return this.numbers.equals(otherRow.numbers);
    }

    @Override
    public int hashCode() {
        return this.numbers.hashCode();
    }
}
