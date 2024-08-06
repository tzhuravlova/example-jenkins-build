import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.List;
public class ReportGeneratorTest {
    @Test
    public void testReportGeneration() {
        List<Student> students = Arrays.asList(
                new Student("Ivan", "Ivanov").withTrainingProgram(),
                new Student("Ivan", "Sidorov").withTrainingProgram(),
                new Student("Taisiia", "Zhuravlova").withTrainingProgram()
        );

        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generate(students);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testGenerateReportWithNullStudents() {
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generate(null);
    }
}
