
public class Main {

    public static void main(String[] args) {
        SimpleDate date1 = new SimpleDate(3, 7, 2011);
        SimpleDate date2 = new SimpleDate(3, 7, 2011);
        SimpleDate date3 = new SimpleDate(4, 8, 2012);

        System.out.println(date1.hashCode());
        System.out.println(date2.hashCode());
        System.out.println(date3.hashCode());
    }
}
