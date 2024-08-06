import courseenum.CourseName;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CourseTest {
    @DataProvider(name = "courseProvider")
    public Object[][] courseProvider() {
        return new Object[][]{
                {new Course(CourseName.JAVA, 30), CourseName.JAVA, 30},
                {new Course(CourseName.SPRING, 25), CourseName.SPRING, 25},
                {new Course(CourseName.SELENIUM, 20), CourseName.SELENIUM, 20}
        };
    }

    @Test(dataProvider = "courseProvider")
    public void testCourseCreation(Course course, CourseName expectedName, int expectedDuration) {
        assertEquals(course.getName(), expectedName);
        assertEquals(course.getDuration(), expectedDuration);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testCourseWithNullName() {
        new Course(null, 30);
    }
}

