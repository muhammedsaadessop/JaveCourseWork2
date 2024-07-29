public class Human implements Comparable<Human> {
    private String name;
    private int wage;

    public Human(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public double getWage() {
        return wage;
    }

    @Override
    public int compareTo(Human another) {
        int thisWage = (int) this.wage;
        int anotherWage = (int) another.wage;
        return Integer.compare(anotherWage, thisWage);
    }
    
    @Override
    public String toString() {
        return name + ": " + wage;
    }
}
