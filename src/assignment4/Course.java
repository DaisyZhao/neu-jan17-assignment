package assignment4;

/**
 * @author Xueying Zhao
 */
public class Course {
    private String courseName;
    private int numberOfStudent;
    Student[] registerStudent = new Student[10];

    public Course(String courseName) {
        this.courseName = courseName;
        this.numberOfStudent = 0;
    }

    public boolean isFull() {
        return this.numberOfStudent >= 10;
    }

    public void registerStudent(Student student) throws RegistrationFailedException {
        if (!isFull()) {
            this.numberOfStudent++;
            registerStudent[this.numberOfStudent - 1] = student;
        } else {
            throw new RegistrationFailedException();
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public Student[] getStudents() {
        return registerStudent;
    }

    public class RegistrationFailedException extends Exception {}

}
