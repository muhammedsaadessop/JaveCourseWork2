import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Student> students;

    public University(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setUniversity(this);
    }

    @Override
    public String toString() {
        return "University{name='" + name + "', students=" + students + "}";
    }
}
