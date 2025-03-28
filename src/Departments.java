import java.lang.reflect.Array;
import java.util.ArrayList;


public class Departments {
    private int department_id; // PRIMARY KEY
    private String name;
    public Departments (int department_id, String name) {
        this.department_id = department_id;
        this.name = name;
    }




    public static void printDepartments (String[] departments, ArrayList<Departments> departmentObjects){
        for (int i = 0; i < departments.length; i++) {
            // INSERT INTO Departments ( departmentID, name ) VALUES ( 1 , 'biology');
            int num = i+1;
            System.out.println("INSERT INTO Departments ( department_id , name ) VALUES ( " + num + ", '" + departments[i] + "' );");
            departmentObjects.add(new Departments(i, departments[i]));
        }
    }
}
