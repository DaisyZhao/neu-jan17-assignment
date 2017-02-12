package assignment4;

/**
 * @author Xueying Zhao
 */
public class Student {
    private String studentName;
    private String studentID;

    public Student(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }
}
