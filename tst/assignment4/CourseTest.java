package assignment4;

import org.junit.Test;

/**
 * Created by zhaoxueying on 2/12/17.
 */
public class CourseTest {
    @Test
    public void testRegisterStudentNormal() throws Course.RegistrationFailedException {
        Course course1 = new Course("Java");
        course1.registerStudent(new Student("a","a1"));
        course1.registerStudent(new Student("b","b1"));
        course1.registerStudent(new Student("c","c1"));
        course1.registerStudent(new Student("d","d1"));
        course1.registerStudent(new Student("e","e1"));
        course1.registerStudent(new Student("f","f1"));
        course1.registerStudent(new Student("g","g1"));
        assert course1.getNumberOfStudent() == 7;
        course1.registerStudent(new Student("h","h1"));
        course1.registerStudent(new Student("i","i1"));
        course1.registerStudent(new Student("j","j1"));
        assert course1.isFull() == true;
        assert course1.getNumberOfStudent() == 10;
    }

    @Test(expected = Course.RegistrationFailedException.class)
    public void testRegisterStudentFail() throws Course.RegistrationFailedException {
        Course course1 = new Course("Java");
        course1.registerStudent(new Student("a","a1"));
        course1.registerStudent(new Student("b","b1"));
        course1.registerStudent(new Student("c","c1"));
        course1.registerStudent(new Student("d","d1"));
        course1.registerStudent(new Student("e","e1"));
        course1.registerStudent(new Student("f","f1"));
        course1.registerStudent(new Student("g","g1"));
        course1.registerStudent(new Student("h","h1"));
        course1.registerStudent(new Student("i","i1"));
        course1.registerStudent(new Student("j","j1"));
        course1.registerStudent(new Student("k","k1"));
    }
}
