public class Warehouse {
    private double capacity;
    private double balance;

    public Warehouse(double capacity) {
        this.capacity = capacity > 0 ? capacity : 0;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public double getCapacity() {
        return capacity;
    }

    public double howMuchSpaceLeft() {
        return capacity - balance;
    }

    public void addToWarehouse(double amount) {
        if (amount > 0) {
            if (amount <= howMuchSpaceLeft()) {
                balance += amount;
            } else {
                balance = capacity;
            }
        }
    }

    public double takeFromWarehouse(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                return amount;
            } else {
                double all = balance;
                balance = 0;
                return all;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "balance = " + balance + ", space left " + howMuchSpaceLeft();
    }
}
