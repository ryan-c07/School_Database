public class Courses {
    private int course_id; // PRIMARY KEY
    private String name;
    private int course_type_id; // FOREIGN KEY

    public Courses(int id, String name, int type_id){
        course_id = id;
        this.name = name;
        course_type_id = type_id;
    }

    public String toString(){
        return "course_id: " + course_id + ", name: " + name + ", course_type_id: " + course_type_id;
    }
}
