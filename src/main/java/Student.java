import java.util.List;
import java.util.Objects;

public class Student {
    private final String name;
    private final String surname;
    private TrainingProgram trainingProgram;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        if (trainingProgram == null) {
            throw new NullPointerException("Training program cannot be null");
        }
        this.trainingProgram = trainingProgram;
    }

    public Student withTrainingProgram() {
        this.trainingProgram = TrainingProgram.random();
        return this;
    }

    public String getNameAndSurname() {
        return String.format("%s %s", this.name, this.surname);
    }

    public String printDetails() {
        List<Course> listOfCourses = this.getTrainingProgram().getListOfCourses();
        StringBuilder formattedCourses = new StringBuilder();
        for (int i = 0; i < listOfCourses.size(); i++) {
            formattedCourses.append(i + 1).append(". ")
                    .append(listOfCourses.get(i).getName()).append("\t\t")
                    .append(listOfCourses.get(i).getDuration()).append("\n");
        }
        return String.format("STUDENT: %s %s\n", this.name, this.surname) +
                String.format("CURRICULUM: %s\n", this.getTrainingProgram().getCurriculum()) +
                String.format("START_DATE: %s\n", this.getTrainingProgram().getStartDate()) +
                "COURSE \t\t\t DURATION (hrs)\n" +
                "---------------------------------\n" +
                formattedCourses.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(trainingProgram, student.trainingProgram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, trainingProgram);
    }
}
