package courseenum;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static courseenum.Curriculum.*;

public enum CourseName {
    JAVA("Java", Curriculum.JD),
    JDBC("JDBC", Curriculum.JD),
    SPRING("Spring", Curriculum.JD),
    TEST_DESIGN("Test design", Curriculum.AQE),
    PAGE_OBJECT("Page object", Curriculum.AQE),
    SELENIUM("Selenium", Curriculum.AQE),
    PLAYWRIGHT("Playwright", Curriculum.AQE),
    UI_TESTS("UI testing", Curriculum.AQE),
    API_TESTS("API testing", Curriculum.AQE);

    private final String displayName;
    private final Curriculum curriculum;

    CourseName(String displayName, Curriculum curriculum) {
        this.displayName = displayName;
        this.curriculum = curriculum;
    }

    private static final List<CourseName> ALL_COURSES = Arrays.asList(values());

    public static CourseName random() {
        return ALL_COURSES.get(new Random().nextInt(ALL_COURSES.size()));
    }

    @Override
    public String toString() {
        return displayName;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    //can not add hashCode() and equals() methods as they cannot be overridden in enums since they are implicitly final in the Enum class.
}