import java.util.ArrayList;
import java.util.List;

public class Suitcase {

    private int maximumWeight;
    private List<Item> items;

    public Suitcase(int maximumWeight) {
        this.items = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }

    public void addItem(Item item) {
        if (this.totalWeight() + item.getWeight() <= this.maximumWeight) {
            this.items.add(item);
        }
    }

    public int totalWeight() {
        return this.items.stream()
                         .mapToInt(Item::getWeight)
                         .sum();
    }

    public void printItems() {
        this.items.stream()
                  .forEach(System.out::println);
    }

    public Item heaviestItem() {
        return this.items.stream()
                         .max((i1, i2) -> Integer.compare(i1.getWeight(), i2.getWeight()))
                         .orElse(null);
    }

    @Override
    public String toString() {
        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (this.items.size() == 1) {
            return "1 item (" + this.totalWeight() + " kg)";
        }

        return this.items.size() + " items (" + this.totalWeight() + " kg)";
    }
}
