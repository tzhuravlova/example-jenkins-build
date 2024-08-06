import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class StudentTest {

    @Test
    public void testStudentCreation() {
        Student student = new Student("John", "Doe");
        assertEquals(student.getName(), "John");
        assertEquals(student.getSurname(), "Doe");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testStudentWithNullTrainingProgram() {
        Student student = new Student("John", "Doe");
        student.setTrainingProgram(null);
    }

    @Test
    public void testStudentWithTrainingProgram() {
        Student student = new Student("Jane", "Doe").withTrainingProgram();
        assertNotNull(student.getTrainingProgram());
    }
}

