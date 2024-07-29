
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainProgram {
 public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Alice", 50000));
        humans.add(new Human("Bob", 60000));
        humans.add(new Human("Charlie", 45000));

        Collections.sort(humans);

        for (Human human : humans) {
            System.out.println(human);
        }
    }
   
   
}
