public class Students {
    private int student_id, grade_level;
    private String first_name, last_name;

    public Students(String first, String last, int grade, int id){
        student_id = id;
        grade_level = grade;
        first_name = first;
        last_name = last;
    }

    public String toString(){
        return "student_id: " + student_id + ", first_name: " + first_name + ", last_name: " + last_name +", grade_level: " + grade_level;
    }
}
