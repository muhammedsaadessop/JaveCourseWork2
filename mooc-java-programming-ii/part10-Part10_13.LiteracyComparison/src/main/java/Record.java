public class Record implements Comparable<Record> {
    private String country;
    private String gender;
    private int year;
    private double literacyRate;

    public Record(String country, String gender, int year, double literacyRate) {
        this.country = country;
        this.gender = gender;
        this.year = year;
        this.literacyRate = literacyRate;
    }

    @Override
    public int compareTo(Record other) {
        return Double.compare(this.literacyRate, other.literacyRate);
    }

    @Override
    public String toString() {
        return String.format("%s (%d), %s, %.5f", country, year, gender, literacyRate);
    }
}
