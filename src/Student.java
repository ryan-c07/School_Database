import java.util.ArrayList;

public class Student {
    private int student_id, grade_level;
    private String first_name, last_name;

    public Student(String first, String last, int grade, int id){
        student_id = id;
        grade_level = grade;
        first_name = first;
        last_name = last;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String toString(){
        return "student_id: " + student_id + ", first_name: " + first_name + ", last_name: " + last_name +", grade_level: " + grade_level;
    }
    public static void printStudents (ArrayList<Student> studentObjects){
        for (int i = 0; i < studentObjects.size(); i++) {
            Student currentStudent = studentObjects.get(i);
            System.out.println("INSERT INTO Student ( student_id, first_name, last_name, grade_level ) VALUES ( " + currentStudent.student_id + ", " +
                    "'" + currentStudent.first_name + "', '" + currentStudent.last_name + "', '" + currentStudent.grade_level + "');");
        }
    }
}
