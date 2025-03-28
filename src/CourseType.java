public class CourseType {
    private int course_type_id; // PRIMARY KEY
    private String course_type;

    public CourseType(int id, String type){
        course_type_id  = id;
        course_type = type;
    }

    public String toString(){
        return "course_type_id: " + course_type_id + ", course_type: " + course_type;
    }
}
