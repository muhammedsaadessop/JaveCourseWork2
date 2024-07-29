import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainProgram {

   public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice"));
        students.add(new Student("bob"));
        students.add(new Student("Charlie"));

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
