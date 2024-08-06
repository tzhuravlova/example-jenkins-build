import courseenum.CourseName;

import java.util.Random;
import java.util.Objects;

public class Course {
    private static final Random random = new Random();
    private CourseName name;
    private int duration;

    public Course(CourseName name, int duration) {
        if (name == null) {
            throw new NullPointerException("Course name cannot be null");
        }
        this.name = name;
        this.duration = duration;
    }

    public static Course random() {
        return new Course(CourseName.random(), random.nextInt(40));
    }

    public CourseName getName() {
        return name;
    }

    public void setName(CourseName name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}