import java.util.List;

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
        // TODO: Add formatted courses
        String formattedCourses = "";
        for (int i = 0; i < listOfCourses.size(); i++) {
            formattedCourses += i + 1 + ". "
                    + listOfCourses.get(i).getName() + "\t\t"
                    + listOfCourses.get(i).getDuration() + "\n";
        }
        return String.format("STUDENT: %s %s\n", this.name, this.surname)
                + String.format("CURRICULUM: %s\n", this.getTrainingProgram().getCurriculum())
                + String.format("START_DATE: %s\n", this.getTrainingProgram().getStartDate())
                + "COURSE \t\t\t DURATION (hrs)\n"
                + "---------------------------------\n"
                + formattedCourses;
    }
}
