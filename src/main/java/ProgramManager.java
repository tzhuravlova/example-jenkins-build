import java.util.Arrays;
import java.util.List;

public class ProgramManager {

    public static void main(String[] args) {
        List<Student> listOfStudents = initializeData();
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generate(listOfStudents);
//        Student student = new Student("Ivan", "Ivanov");
//        student.printDetails();
    }

    public static List<Student> initializeData() {
        return Arrays.asList(
                new Student("Ivan", "Ivanov").withTrainingProgram(),
                new Student("Ivan", "Sidorov").withTrainingProgram(),
                new Student("Taisiia", "Zhuravlova").withTrainingProgram());
    }

}
//generate and divide into packages
//remove statics almost everywhere //done
//add hashCode and equals() in Student in Trianing prgrm, course //done
//make everything that i can private and final //done
// if (tempDateTime.getHour() >= 10 && tempDateTime.getHour() < 18) put in constants from report generator //done
//unit tests, at least one parametrized , one negative that will throw exception