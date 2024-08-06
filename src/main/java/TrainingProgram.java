import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Random;

public class TrainingProgram {
    private static final Random RANDOM = new Random();
    private final String curriculum;
    private final LocalDateTime startDate;
    private final List<Course> listOfCourses;

    private TrainingProgram(String curriculum, LocalDateTime startDate, List<Course> listOfCourses) {
        this.curriculum = curriculum;
        this.startDate = startDate;
        this.listOfCourses = listOfCourses;
    }

    public static TrainingProgram random() {
        return new TrainingProgram(
                "AQE",
                generateRandomDate(),
                generateNumberOfRandomCourses(RANDOM.nextInt(5) + 1)
        );
    }

    private static List<Course> generateNumberOfRandomCourses(int numberOfCourses) {
        List<Course> listOfCourses = new ArrayList<>();
        for (int i = 0; i < numberOfCourses; i++) {
            listOfCourses.add(Course.random());
        }
        return listOfCourses;
    }

    public static LocalDateTime generateRandomDate() {
        LocalDateTime startDate = LocalDateTime.of(2024, 1, 1, 0, 0); // Start date
        LocalDateTime endDate = LocalDateTime.of(2024, 12, 31, 23, 59); // End date
        return LocalDateTime.ofEpochSecond(RANDOM.nextInt((int) ChronoUnit.DAYS.between(startDate, endDate)) * 24 * 3600, 0, ZoneOffset.UTC);
    }

    public String getCurriculum() {
        return curriculum;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    public int getDurationOfAllCourses() {
        return listOfCourses.stream().mapToInt(Course::getDuration).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingProgram that = (TrainingProgram) o;
        return Objects.equals(curriculum, that.curriculum) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(listOfCourses, that.listOfCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curriculum, startDate, listOfCourses);
    }
}
