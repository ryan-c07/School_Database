import java.util.ArrayList;

public class Course {
    private int course_id; // PRIMARY KEY
    private String name;
    private CourseType course_type_id; // FOREIGN KEY


    public Course(int course_id, String name, CourseType course_type_id) {
        this.course_id = course_id;
        this.name = name;
        this.course_type_id = course_type_id;
    }


    public static void printCourses (ArrayList<Course> courseObjects){
        for (int i = 0; i < courseObjects.size(); i++) {
            System.out.println("INSERT INTO Course ( course_id, name, course_type_id ) VALUES ( " + courseObjects.get(i).course_id + ", \"" + courseObjects.get(i).name + "\"" + ", " + courseObjects.get(i).course_type_id.getCourse_type_id() + " );");
        }
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public CourseType getCourse_type_id() {
        return course_type_id;
    }

    public void setCourse_type_id(CourseType course_type_id) {
        this.course_type_id = course_type_id;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "course_id=" + course_id +
                ", name='" + name + '\'' +
                ", course_type_id=" + course_type_id +
                '}';
    }


}
