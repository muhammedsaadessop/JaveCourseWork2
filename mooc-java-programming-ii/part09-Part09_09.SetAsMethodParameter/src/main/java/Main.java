import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int returnSize(Set<?> set) {
        return set.size();
    }

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("first");
        names.add("first");
        names.add("second");
        names.add("second");
        names.add("second");

        System.out.println(returnSize(names));
    }

}
