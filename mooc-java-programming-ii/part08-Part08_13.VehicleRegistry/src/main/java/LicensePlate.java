public class LicensePlate {
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LicensePlate that = (LicensePlate) object;
        return liNumber.equals(that.liNumber) && country.equals(that.country);
    }

    @Override
    public int hashCode() {
        int result = country.hashCode();
        result = 31 * result + liNumber.hashCode();
        return result;
    }
}
