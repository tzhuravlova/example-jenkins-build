package courseenum;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static courseenum.Curriculum.*;

public enum CourseName {
    JAVA("Java", JD),
    JDBC("JDBC", JD),
    SPRING("Spring", JD),
    TEST_DESIGN("Test design", AQE),
    PAGE_OBJECT("Page object", AQE),
    SELENIUM("Selenium", AQE),
    PLAYWRIGHT("Playwright", AQE),
    UI_TESTS("UI testing", AQE),
    API_TESTS("API testing", AQE);

    String displayName;
    Curriculum curriculum;

    CourseName(String displayName, Curriculum curriculum){
        this.displayName = displayName;
        this.curriculum = curriculum;
    }

    private static List<CourseName> allCourses(){
        return Arrays.asList(JAVA, JDBC, SPRING, TEST_DESIGN, PAGE_OBJECT, SELENIUM, PLAYWRIGHT, UI_TESTS, API_TESTS);
    }

    public static CourseName random(){
        return allCourses().get(new Random().nextInt(allCourses().size()));
    }

    @Override
    public String toString() {
        return displayName;
    }
}
