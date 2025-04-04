import java.util.ArrayList;

public class Teachers {
    private int teacher_id, department_id;
    private String first_name, last_name;

    public Teachers (int teacher_id, int department_id, String first_name, String last_name){
        this.teacher_id = teacher_id;
        this.department_id = department_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public static void printTeachers (ArrayList<Teachers> teacherObjects){
        for (int i = 0; i < teacherObjects.size(); i++) {
            Teachers currentTeacher = teacherObjects.get(i);
            System.out.println("INSERT INTO Teachers ( teacher_id, first_name, last_name, department_id ) VALUES ( " + currentTeacher.teacher_id + ", " +
                    "'" + currentTeacher.first_name + "', '" + currentTeacher.last_name + "', '" + currentTeacher.department_id + "');");
        }
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return teacher_id + "|" + department_id + "|" + first_name + "|" + last_name;
    }
}
