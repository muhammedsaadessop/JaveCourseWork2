public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        SimpleDate otherDate = (SimpleDate) object;
        return day == otherDate.day && month == otherDate.month && year == otherDate.year;
    }

    public static void main(String[] args) {
        // Test case
        boolean isIt = new SimpleDate(3, 7, 2011).equals(new SimpleDate(3, 7, 2011));
        System.out.println(isIt); // should print true
    }
}
