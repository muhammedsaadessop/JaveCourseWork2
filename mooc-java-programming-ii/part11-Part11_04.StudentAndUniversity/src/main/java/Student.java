public class Student {
    private int studentID;
    private String name;
    private University university;

    public Student(int studentID, String name, University university) {
        this.studentID = studentID;
        this.name = name;
        this.university = university;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{studentID=" + studentID + ", name='" + name + "', university=" + university + "}";
    }
}
