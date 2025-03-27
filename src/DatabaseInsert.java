import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;


public class DatabaseInsert {
    public static void main(String[] args) {
        // INSERT INTO Students ( StudentID, Name ) VALUES ( 5000 , 'Student200 ');
        for (int i = 1; i <= 5000; i++) {
            System.out.println("INSERT INTO Students ( student_id, name ) VALUES ( " + i + ", 'Student" + i + "' );");
        }
        String[] departments = {"Biology", "Chemistry", "CTE, Computer Science & Engineering", "English",
                "Mathematics", "Physics", "Social Studies", "Special Education", "Visual & Performing Arts", "World Languages & ENL"};
        ArrayList<Departments> departmentObjects = new ArrayList<>();
        Departments.printDepartments(departments, departmentObjects);




    }
}