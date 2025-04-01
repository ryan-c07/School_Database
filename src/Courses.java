import java.util.ArrayList;

public class Courses {
    private int course_id; // PRIMARY KEY
    private String name;
    private CourseType course_type_id; // FOREIGN KEY


    public Courses (int course_id, String name, CourseType course_type_id) {
        this.course_id = course_id;
        this.name = name;
        this.course_type_id = course_type_id;
    }


    public static void printCourses (String[] courses, ArrayList<Courses> courseObjects, CourseType course_type_id){
        for (int i = 0; i < courses.length; i++) {
            System.out.println("INSERT INTO Courses ( course_id , name, course_type_id ) VALUES ( " + i + ", '" + courses[i] + "'" + ", " + course_type_id.getCourse_type_id() + " );");
            courseObjects.add(new Courses(i, courses[i], course_type_id));
        }
    }
}
