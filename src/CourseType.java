public class CourseType {
    private int course_type_id; // PRIMARY KEY
    private String course_type;

    public CourseType(int course_type_id, String course_type) {
        this.course_type_id = course_type_id;
        this.course_type = course_type;
    }

    public int getCourse_type_id() {
        return course_type_id;
    }

    public String getCourse_type() {
        return course_type;
    }

    public String toString(){
        return "course_type_id: " + course_type_id + ", course_type: " + course_type;
    }
}
