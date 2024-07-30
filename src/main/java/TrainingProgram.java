import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrainingProgram {
    private static Random random = new Random();
    private String curriculum;
    private LocalDateTime startDate;
    private List<Course> listOfCourses;

    public static TrainingProgram random() {
        return new TrainingProgram()
                .withCurriculum("AQE")
                .withListOfCourses(generateNumberOfRandomCourses(random.nextInt(5) + 1))
                .withStartDate(generateRandomDate());
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
        return LocalDateTime.ofEpochSecond(new Random().nextInt((int) ChronoUnit.DAYS.between(startDate, endDate)) * 24 * 3600, 0, ZoneOffset.UTC);
    }

    public String getCurriculum() {
        return curriculum;
    }

    public TrainingProgram withCurriculum(String curriculum) {
        this.curriculum = curriculum;
        return this;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public TrainingProgram withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    public TrainingProgram withListOfCourses(List<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
        return this;
    }

    public int getDurationOfAllCourses() {
        int duration = 0;
        for (Course course : listOfCourses) {
            duration += course.getDuration();
        }
        return duration;
    }
}
