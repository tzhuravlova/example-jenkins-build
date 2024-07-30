import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class ReportGenerator {
    public void generate(List<Student> studentsList) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(String.format("Short (Generating report date - %s) :", now));
        for (Student student : studentsList) {
            System.out.println(String.format(
                    "%s (%s) - %s",
                    student.getNameAndSurname(), student.getTrainingProgram().getCurriculum(), isCompleted(student)));
        }
    }

    private String isCompleted(Student student) {
        LocalDateTime now = LocalDateTime.now();
        long remainingHours = calculateRemainingHours(student.getTrainingProgram().getStartDate(), now,
                student.getTrainingProgram().getDurationOfAllCourses());
        if (remainingHours <= 0) {
            return String.format("Training completed. %s hours have passed since the end.", -remainingHours);
        } else {
            return String.format("Training is not finished. %s hours are left until the end.", remainingHours);
        }
    }

    private long calculateRemainingHours(LocalDateTime startDate, LocalDateTime currentDate, int courseDuration) {
        LocalDateTime tempDateTime = LocalDateTime.from(startDate);
        long remainingHours = courseDuration;

        while (tempDateTime.isBefore(currentDate)) {
            if (tempDateTime.getDayOfWeek() != DayOfWeek.SATURDAY && tempDateTime.getDayOfWeek() != DayOfWeek.SUNDAY) {
                if (tempDateTime.getHour() >= 10 && tempDateTime.getHour() < 18) {
                    remainingHours -= 1;
                }
            }
            tempDateTime = tempDateTime.plusHours(1);
        }
        return remainingHours;
    }
}
